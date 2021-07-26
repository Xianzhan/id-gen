package xianzhan.id.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xianzhan.id.pojo.dto.UserDTO;
import xianzhan.id.pojo.param.UserParam;
import xianzhan.id.service.IUserService;
import xianzhan.id.util.Response;

import javax.annotation.Resource;

/**
 * @author xianzhan
 * @since 2020-07-15
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    private IUserService userService;

    @ResponseBody
    @RequestMapping("/register")
    public Response<UserDTO> register(UserParam param) {
        LOGGER.info("用户注册, 请求参数: {}", param);
        return Response.ok(userService.register(param));
    }
}
