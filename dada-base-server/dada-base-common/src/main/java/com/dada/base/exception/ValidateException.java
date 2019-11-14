package com.dada.base.exception;


import com.dada.base.enums.ErrorCode;

public class ValidateException extends Exception {

    private static final long serialVersionUID = -579605355420939805L;

    private ErrorCode errorCode;

    private String code;

    private String desc;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public ValidateException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.code = errorCode.getCode();
        this.desc = errorCode.getDesc();
    }

    public ValidateException(ErrorCode errorCode, String code) {
        this.errorCode = errorCode;
        this.code = code;
    }

    public ValidateException(ErrorCode errorCode, String code, String desc) {
        this.errorCode = errorCode;
        this.code = code;
        this.desc = desc;
    }

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateException(Throwable cause) {
        super(cause);
    }
}
