package xianzhan.id.pojo.dto;

import lombok.Data;
import xianzhan.id.pojo.entity.User;

/**
 * User 对外暴露数据
 *
 * @author xianzhan
 * @see xianzhan.id.pojo.entity.User
 * @since 2020-07-16
 */
@Data
public class UserDTO {

    private Long userId;

    public static UserDTO of(User user) {
        UserDTO userDTO = new UserDTO();
        if (user == null) {
            return userDTO;
        }

        userDTO.setUserId(user.getUserId());
        return userDTO;
    }
}
