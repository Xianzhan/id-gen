package xianzhan.id.manager.impl;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xianzhan.id.manager.IUserManager;
import xianzhan.id.mapper.CommonConfigMapper;
import xianzhan.id.mapper.UserIdGenMapper;

import javax.annotation.Resource;

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

        return null;
    }
}
