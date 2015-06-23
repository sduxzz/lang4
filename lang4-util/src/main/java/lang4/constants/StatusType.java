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
     OK(200),

    /**
     * system error
     */
     SYS_ERROR(100),

    /**
     * parameters are invalid
     */
     PARAM_ERROR(300),

    /**
     * no authority error
     */
     AUTH_ERROR(400),

    /**
     * forbidden by system
     */
     FORBID_ERROR(500),

    /**
     * request timeout
     */
     TIMEOUT_ERROR(600);

     private int code;
     
     private StatusType(int code) {
         this.code = code;
     }

    public int getCode() {
        return code;
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