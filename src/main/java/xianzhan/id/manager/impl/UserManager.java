package xianzhan.id.manager.impl;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import xianzhan.id.exception.ServiceException;
import xianzhan.id.manager.IUserManager;
import xianzhan.id.mapper.CommonConfigMapper;
import xianzhan.id.mapper.UserIdGenMapper;
import xianzhan.id.pojo.entity.UserIdGen;
import xianzhan.id.util.Constants;
import xianzhan.id.util.JsonUtils;
import xianzhan.id.util.Numbers;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xianzhan
 * @since 2020-07-16
 */
@Service
public class UserManager implements IUserManager {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private CommonConfigMapper configMapper;
    @Resource
    private UserIdGenMapper    userIdGenMapper;

    @Override
    @Transactional(rollbackFor = {Error.class, Exception.class})
    public Long genUserId() {
        final int index = Numbers.random(0, Constants.USER_ID_GEN_SIZE);

        // todo 应先获取分布式锁, 然后处理数据, 类似 1.7 的分段锁

        ListOperations<String, String> listOp = stringRedisTemplate.opsForList();
        String json = listOp.index(Constants.USER_ID_GEN_LIST, index);
        if (StringUtils.isEmpty(json)) {
            Long size = listOp.size(Constants.USER_ID_GEN_LIST);
            if (Long.valueOf(0L).equals(size)) {
                // 初始化
                List<String> jsonList = initUserIdCacheAndReturnList(listOp);
                json = jsonList.get(index);
            } else {
                throw new ServiceException("生成用户 ID 缓存异常");
            }
        }
        UserIdGen userIdGen = JsonUtils.toObj(json, UserIdGen.class);

        Long used = userIdGen.getUsed();
        List<Integer> indexList = Numbers.listIndexBin(used, 0);
        if (indexList.isEmpty()) {
            throw new ServiceException("该实例已使用完, 但未被删除");
        }

        int size = indexList.size();
        int random = Numbers.random(0, size);
        Integer add = indexList.get(random);
        Long startId = userIdGen.getStartId();
        long userId = startId + add;
        if (size == 1) {
            // todo 删除 user_id_gen 对应记录并新增一条
            throw new ServiceException("todo 删除 user_id_gen 对应记录并新增一条");
        }

        // 跟新 redis
        used = Numbers.setIndexBin(used, add, 1);
        userIdGen.setUsed(used);
        json = JsonUtils.toJson(userIdGen);
        listOp.set(Constants.USER_ID_GEN_LIST, index, json);

        return userId;
    }

    private List<String> initUserIdCacheAndReturnList(ListOperations<String, String> listOp) {
        List<UserIdGen> userIdGens = userIdGenMapper.selectToCache(Constants.USER_ID_GEN_SIZE);
        int size = userIdGens.size();
        if (size < Constants.USER_ID_GEN_SIZE) {
            // todo 当数据不够时, 生成数据并插入数据库
            throw new ServiceException("可用用户 ID 太少: " + size);
        }

        List<String> jsonList = new ArrayList<>();
        for (UserIdGen userIdGen : userIdGens) {
            String json = JsonUtils.toJson(userIdGen);
            jsonList.add(json);
        }
        listOp.leftPushAll(Constants.USER_ID_GEN_LIST, jsonList);
        return jsonList;
    }
}
