package xianzhan.id.exception;

/**
 * 业务异常类
 *
 * @author xianzhan
 * @since 2020-07-16
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
