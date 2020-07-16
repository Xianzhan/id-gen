package xianzhan.id.redis;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import xianzhan.id.AppTest;

/**
 * @author xianzhan
 * @since 2020-07-15
 */
public class RedisTest extends AppTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSet() {
        ValueOperations<String, String> set = stringRedisTemplate.opsForValue();
        set.set("one", "1");
        Assert.assertEquals("1", set.get("one"));
    }
}
