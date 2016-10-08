package us.waw.gaara.common;

/**
 * Created by lenn on 16/7/13.
 */
public class Response {
    private int code;
    private String msg;

    public Response() {
        this.code = Status.CODE_SUCCESS;
        this.msg = Status.MSG_SUCCESS;
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
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

    public void setStatus(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public void setSuccessStatus(){
        this.setStatus(Status.CODE_SUCCESS, Status.MSG_SUCCESS);
    }

    public static class Status {
        public final static int CODE_SUCCESS = 0;
        public final static String MSG_SUCCESS = "操作成功.";

        public final static int CODE_INVALID_CLIENT_ID = 20001;
        public final static String MSG_INVALID_CLIENT_ID = "非法的client id.";

        public final static int CODE_INVALID_CLIENT_SECRET_KEY = 20002;
        public final static String MSG_INVALID_CLIENT_SECRET_KEY = "非法的client secret key.";

        public final static int CODE_INVALID_AUTH_CODE = 20003;
        public final static String MSG_INVALID_AUTH_CODE = "非法的授权码.";

    }
}
