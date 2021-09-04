package xianzhan.id.util;

import lombok.Data;

/**
 * @author xianzhan
 * @since 2020-07-15
 */
@Data
public class Response<T> {

    public static final int OK   = 0;
    public static final int FAIL = -1;

    private int    code;
    private String msg;
    private T      data;

    public static <T> Response<T> ok(T data) {
        Response<T> res = new Response<>();
        res.setCode(OK);
        res.setData(data);
        return res;
    }

    public static <T> Response<T> fail(T data, String msg) {
        Response<T> res = new Response<>();
        res.setCode(FAIL);
        res.setMsg(msg);
        res.setData(data);
        return res;
    }
}
