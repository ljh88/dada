/*
 * @(#)BaseException  1.0 2018/4/2
 *
 * Copyright 2014-2019 chinabank payment All Rights Reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * Author Email: heke@jd.com
 */

package com.dada.base.exception;


import com.dada.base.enums.ErrorCode;

public class BaseException extends Exception {
    private static final long serialVersionUID = 4146382191191884362L;

    private ErrorCode errorCode;

    private String code;

    private String desc;

    public BaseException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.code = errorCode.getCode();
        this.desc = errorCode.getDesc();
    }

    public BaseException(ErrorCode errorCode, String code) {
        this.errorCode = errorCode;
        this.code = code;
    }

    public BaseException(ErrorCode errorCode, String code, String desc) {
        this.errorCode = errorCode;
        this.code = code;
        this.desc = desc;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
