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

    /**
     * system error
     */
    SYS_ERROR(100, "system error"),

    /**
     * parameters are invalid
     */
    PARAM_ERROR(300, "request parameters are invalid"),

    /**
     * no authority error
     */
    AUTH_ERROR(400, "you don't has this authority"),

    /**
     * no login
     */
    NO_LOGIN_ERROR(401, "hasn't login yet"),

    /**
     * forbidden by system
     */
    FORBID_ERROR(500, "forbidden by system"),

    /**
     * request timeout
     */
    TIMEOUT_ERROR(600, "request timeout");

    private int code;
    private String message;

    private StatusType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
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