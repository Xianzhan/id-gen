package xianzhan.id.pojo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author xianzhan
 * @since 2020-07-15
 */
@Data
public class User {

    private Long id;
    private Long userId;
    private Date createTime;
    private Date updateTime;
}
