package xianzhan.id.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xianzhan.id.util.Response;

/**
 * 该 Controller 用于测试
 *
 * @author xianzhan
 * @since 2020-07-16
 */
@Controller
@RequestMapping("/ex")
public class ExceptionController {

    @RequestMapping("/byZero")
    public Response<Integer> exception() {
        int result = 1;
        for (int i = 1; i > -1; i--) {
            result /= i;
        }
        return Response.ok(result);
    }
}
