package xianzhan.id.util;

/**
 * @author xianzhan
 * @since 2020-07-15
 */
public class Response<T> {

    public static final int OK = 0;

    private int    code;
    private String msg;
    private T      data;

    public static <T> Response<T> ok(T data) {
        Response<T> res = new Response<>();
        res.setCode(OK);
        res.setData(data);
        return res;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
               "code=" + code +
               ", msg='" + msg + '\'' +
               ", data=" + data +
               '}';
    }
}
