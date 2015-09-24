package lang4.constants;

import lang4.util.A;

/**
 * 
 * 响应的状态码
 * 
 * @author xiezhenzong
 *
 */
public enum StatusType {

    /**
     * request successful
     */
    OK(200, "ok"),

    SYS_ERROR(100, "system error"),

    PARAM_ERROR(300, "request parameters are invalid"),

    AUTH_ERROR(400, "you don't has this authority"),

    NO_LOGIN_ERROR(401, "hasn't login yet"),

    WRONG_USER_OR_PWD(402, "用户不存在或者密码错误"),

    FORBID_ERROR(500, "forbidden by system"),

    TIMEOUT_ERROR(600, "request timeout");

    public int code;
    public String message;

    private StatusType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * parse specific code to StatusType
     * 
     */
    public static StatusType parse(int code) {
        final StatusType[] statuses = StatusType.values();
        if (A.isEmpty(statuses)) {
            throw new IllegalStateException("No StatusType in class.");
        }

        for (StatusType status : statuses)
            if (status.code == code)
                return status;

        throw new IllegalArgumentException("Can't find StatusType for code: " + code);
    }

}