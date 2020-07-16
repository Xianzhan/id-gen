package xianzhan.id.mapper;

import org.springframework.stereotype.Repository;
import xianzhan.id.entity.User;

import java.util.List;

/**
 * @author xianzhan
 * @since 2020-07-15
 */
@Repository
public interface UserMapper {

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 根据 query 条件查询
     *
     * @param query 条件
     * @return list
     */
    List<User> selectBy(User query);
}
