package xianzhan.id.service.impl;

import org.springframework.stereotype.Service;
import xianzhan.id.manager.IUserManager;
import xianzhan.id.mapper.UserMapper;
import xianzhan.id.pojo.dto.UserDTO;
import xianzhan.id.pojo.entity.User;
import xianzhan.id.pojo.param.UserParam;
import xianzhan.id.service.IUserService;
import xianzhan.id.util.AssertUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author xianzhan
 * @since 2020-07-16
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserManager userManager;

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDTO register(UserParam userParam) {
        validUser(userParam);

        User user = new User();
        // userParam 与 user 的转化
        // 可以写 UserDTO#of 之类的方法, 或者使用 BeanUtils 之类的工具类
        // 此处忽视

        // 生成用户 ID
        Long userId = userManager.genUserId();
        user.setUserId(userId);

        Date now = new Date();
        user.setCreateTime(now);
        user.setUpdateTime(now);
        int insert = userMapper.insert(user);
        AssertUtils.equals(1, insert, "用户注册失败");

        return UserDTO.of(user);
    }

    private void validUser(UserParam userParam) {
        // 验证账号数据
        // do nothing
    }
}
