/**
 * Copyright (C) 2015 haixiaoyao, Inc. All Rights Reserved.
 */
package lang4.constants;

/**
 * 
 * 异常的类型
 * 
 * @author xiezhenzong
 *
 */
public enum ErrorType {
    
    SYS_ERROR(StatusType.SYS_ERROR.getCode(), "system error"),

    PARAM_ERROR(StatusType.PARAM_ERROR.getCode(), "request parameters are invalid"),

    AUTH_ERROR(StatusType.AUTH_ERROR.getCode(), "you don't has this authority"),

    FORBID_ERROR(StatusType.FORBID_ERROR.getCode(), "forbidden by system"),

    TIMEOUT_ERROR(StatusType.TIMEOUT_ERROR.getCode(), "request timeout");

    /**
     * 异常的分类
     * 
     * @see Status
     */
    public int errorCategory;

    /**
     * 异常的子情况；
     * 
     * 如果没有特殊需求，则可以和分类一致；
     * 
     * 如果需要返回特定的错误，就用这个字段来传递；
     * 
     * 规范用四位数，用于和三位数的{@code errorCategory}区分
     */
    public int errorCode;

    /**
     * 错误的提示信息
     */
    public String errorMessage;

    /**
     * 没有必要细分异常的类型，errorCode ＝ 0
     * 
     */
    private ErrorType(int errorCategory, String errorMessage) {
        this(errorCategory, errorCategory, errorMessage);
    }

    private ErrorType(int errorCategory, int errorCode, String errorMessage) {
        this.errorCategory = errorCategory;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{errorCategory: ").append(errorCategory).append(",");
        buffer.append("errorCode: ").append(errorCode).append(", ");
        buffer.append("errorMessage: \"").append(errorMessage).append("\"}");
        return buffer.toString();
    }

}
