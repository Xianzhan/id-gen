package xianzhan.id.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @ResponseBody
    @RequestMapping("/register")
    public Response<UserDTO> register(UserParam param) {
        log.info("User - register");
        return Response.ok(userService.register(param));
    }
}
