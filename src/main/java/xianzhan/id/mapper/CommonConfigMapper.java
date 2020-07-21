package xianzhan.id.mapper;

import org.springframework.stereotype.Repository;
import xianzhan.id.pojo.entity.CommonConfig;

import java.util.List;

/**
 * @author xianzhan
 * @since 2020-07-15
 */
@Repository
public interface CommonConfigMapper {

    /**
     * 根据 query 条件查询
     *
     * @param query 条件
     * @return list
     */
    List<CommonConfig> selectBy(CommonConfig query);

    /**
     * 根据 ID 跟新数据
     *
     * @param update 数据
     * @return 影响行数
     */
    int updateById(CommonConfig update);

    /**
     * 插入一行
     *
     * @param row 行数据
     * @return 影响行数
     */
    int insert(CommonConfig row);
}
