package xianzhan.id.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xianzhan.id.AppTest;
import xianzhan.id.pojo.entity.User;

import java.util.Date;

/**
 * @author xianzhan
 * @since 2020-07-15
 */
public class UserMapperTest extends AppTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        Date now = new Date();

        User user = new User();
        user.setUserId(1L);
        user.setCreateTime(now);
        user.setUpdateTime(now);

        int insert = userMapper.insert(user);
        Assert.assertEquals(1, insert);
    }
}
