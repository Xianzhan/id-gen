package xianzhan.id.mapper;

import org.springframework.stereotype.Repository;
import xianzhan.id.pojo.entity.UserIdGen;

import java.util.List;

/**
 * @author xianzhan
 * @since 2020-07-15
 */
@Repository
public interface UserIdGenMapper {

    /**
     * 新增用户 ID 记录
     *
     * @param userIdGen 记录
     * @return 影响行数
     */
    int insert(UserIdGen userIdGen);

    /**
     * 根据 startId 删除数据
     *
     * @param startId 起始 ID
     * @return 影响行数
     */
    int deleteByStartId(Long startId);

    /**
     * 根据条件查询数据
     *
     * @param userIdGen 条件
     * @return list
     */
    List<UserIdGen> selectBy(UserIdGen userIdGen);

    /**
     * 查询可使用的 ID 范围
     *
     * @param size size
     * @return list
     */
    List<UserIdGen> selectToCache(int size);

    /**
     * 根据 startId 更新数据
     *
     * @param userIdGen 数据
     * @return 影响行数
     */
    int updateByStartId(UserIdGen userIdGen);
}
