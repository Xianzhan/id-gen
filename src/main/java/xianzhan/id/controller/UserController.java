package xianzhan.id.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xianzhan.id.util.Response;

/**
 * @author xianzhan
 * @since 2020-07-15
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @ResponseBody
    @RequestMapping("/register")
    public Response<Long> register() {
        return Response.ok(123L);
    }
}
