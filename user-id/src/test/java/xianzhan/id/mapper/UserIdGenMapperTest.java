package xianzhan.id.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xianzhan.id.AppTest;
import xianzhan.id.pojo.entity.UserIdGen;
import xianzhan.id.util.Constants;

import java.io.IOException;
import java.util.List;

/**
 * @author xianzhan
 * @since 2020-07-15
 */
public class UserIdGenMapperTest extends AppTest {

    @Autowired
    private UserIdGenMapper idGenMapper;

    @Test
    public void insert() {
        UserIdGen userIdGen = new UserIdGen();
        userIdGen.setStartId(0L);
        userIdGen.setEndId(16L);
        userIdGen.setUsed(0L);

        int insert = idGenMapper.insert(userIdGen);
        Assert.assertEquals(1, insert);
    }

    @Test
    public void updateByStartId() {
        UserIdGen userIdGen = new UserIdGen();
        userIdGen.setStartId(0L);
        userIdGen.setUsed(1L);

        int i = idGenMapper.updateByStartId(userIdGen);
        Assert.assertEquals(1, i);
    }

    @Test
    public void selectBy() {
        UserIdGen query = new UserIdGen();
        query.setStartId(0L);

        List<UserIdGen> userIdGens = idGenMapper.selectBy(query);
        Assert.assertEquals(1, userIdGens.size());
    }

    @Test
    public void deleteByStartId() {
        int i = idGenMapper.deleteByStartId(0L);
        Assert.assertEquals(1, i);
    }

    @Test
    public void selectToCache() {
        List<UserIdGen> userIdGens = idGenMapper.selectToCache(Constants.USER_ID_GEN_SIZE);
        userIdGens.forEach(obj -> {
            ObjectMapper mapper = new ObjectMapper();
            try {
                String json = mapper.writeValueAsString(obj);
                System.out.println(json);
                UserIdGen userIdGen = mapper.readValue(json, UserIdGen.class);
                System.out.println(userIdGen);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Assert.assertTrue(userIdGens.size() < Constants.USER_ID_GEN_SIZE + 1);
    }
}
