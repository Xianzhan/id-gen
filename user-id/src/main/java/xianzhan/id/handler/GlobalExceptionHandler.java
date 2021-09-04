package xianzhan.id.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import xianzhan.id.util.Response;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 全局异常处理
 *
 * @author xianzhan
 * @since 2020-07-16
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Response<Map<String, String[]>> handleException(HttpServletRequest req, Exception e) {
        Map<String, String[]> parameterMap = req.getParameterMap();
        log.error("未知异常, 请求参数:{}, 错误: {}", parameterMap, e);
        return Response.fail(parameterMap, "系统错误, 请联系管理员");
    }
}
