package xianzhan.id.util;

import xianzhan.id.exception.ServiceException;

/**
 * @author xianzhan
 * @since 2020-07-16
 */
public class AssertUtils {

    public static void equals(int expected, int actual, String err) {
        if (actual != expected) {
            throw new ServiceException(err);
        }
    }
}
