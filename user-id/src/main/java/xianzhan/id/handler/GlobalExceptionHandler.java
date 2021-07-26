package xianzhan.id.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Response<Map<String, String[]>> handleException(HttpServletRequest req, Exception e) {
        Map<String, String[]> parameterMap = req.getParameterMap();
        LOGGER.error("未知异常, 请求参数:{}, 错误: {}", parameterMap, e);
        return Response.fail(parameterMap, "系统错误, 请联系管理员");
    }
}
