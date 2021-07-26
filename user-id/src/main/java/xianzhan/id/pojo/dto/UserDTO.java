package xianzhan.id.pojo.dto;

import xianzhan.id.pojo.entity.User;

/**
 * User 对外暴露数据
 *
 * @author xianzhan
 * @see xianzhan.id.pojo.entity.User
 * @since 2020-07-16
 */
public class UserDTO {

    public static UserDTO of(User user) {
        UserDTO userDTO = new UserDTO();
        if (user == null) {
            return userDTO;
        }

        userDTO.setUserId(user.getUserId());
        return userDTO;
    }

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
               "userId=" + userId +
               '}';
    }
}
