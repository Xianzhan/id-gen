package xianzhan.id.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xianzhan.id.AppTest;
import xianzhan.id.pojo.entity.CommonConfig;
import xianzhan.id.util.Constants;

/**
 * @author xianzhan
 * @since 2020-07-15
 */

public class CommonConfigMapperTest extends AppTest {

    @Autowired
    private CommonConfigMapper commonConfigMapper;

    @Test
    public void insert() {
        CommonConfig config = new CommonConfig();
        config.setCategory(Constants.USER_ID);
        config.setKey(Constants.USER_ID_MIN);
        // 1 << 17 大于 10 万
        config.setValue("131072");

        int insert = commonConfigMapper.insert(config);
        Assert.assertEquals(1, insert);
    }

    @Test
    public void updateById() {
        CommonConfig config = new CommonConfig();
        config.setCategory(Constants.USER_ID);
        config.setKey(Constants.USER_ID_MIN);
        // 1 << 17 大于 10 万
        config.setValue("131072");
        config.setId(1L);
        int i = commonConfigMapper.updateById(config);
        Assert.assertEquals(1, i);
    }
}
