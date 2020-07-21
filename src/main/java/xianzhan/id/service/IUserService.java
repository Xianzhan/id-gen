package xianzhan.id.service;

import xianzhan.id.pojo.dto.UserDTO;
import xianzhan.id.pojo.param.UserParam;

/**
 * 用户服务接口
 *
 * @author xianzhan
 * @since 2020-07-16
 */
public interface IUserService {

    /**
     * 注册
     *
     * @param userParam 账号信息
     * @return dto
     */
    UserDTO register(UserParam userParam);
}
