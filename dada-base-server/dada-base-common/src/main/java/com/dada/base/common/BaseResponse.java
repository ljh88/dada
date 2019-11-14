/*
 * @(#)BaseResponse 1.0 2016/11/6
 *
 * Copyright 2016 JDJR All Rights Reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * Author Email: fenghao1@jd.com
 */
package com.dada.base.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import static javax.servlet.http.HttpServletResponse.*;


/**
 * @author fenghao, 2016/11/6
 * @version 1.0
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
    /**
     * 响应编码
     */
    private int code;

    /**
     * 响应状态编码
     */
    private String status;

    /**
     * 响应描述
     */
    private String msg;
    /**
     * 跳转地址
     */
    private String url;

    /**
     * 数据信息
     */
    private T data;

    /**
     * @return code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.code == 1;
    }

    public String getError() {
        return this.msg;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", status=" + status +
                ", msg='" + msg + '\'' +
                ", url='" + url + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public void buildSuccessResponse() {
        setCode(SC_OK);
    }

    public void buildSuccessResponse(String msg) {
        setCode(SC_OK);
        setMsg(msg);
    }

    public void buildBadResponse(int code, String msg) {
        setCode(code);
        setMsg(msg);
    }

    public void buildMovedTemporarilyResponse(String url) {
        buildMovedTemporarilyResponse(url, null, null);
    }


    public void buildMovedTemporarilyResponse(String url, String status, String msg) {
        setUrl(url);
        buildResponse(SC_MOVED_TEMPORARILY, status, msg);
    }

    public void buildBadRequestResponse(String status, String msg) {
        buildResponse(SC_BAD_REQUEST, status, msg);
    }


    public void buildServerErrorResponse(String status, String msg) {
        buildResponse(SC_INTERNAL_SERVER_ERROR, status, msg);
    }

    public void buildResponse(int code, String status, String msg) {
        setCode(code);
        setStatus(status);
        setMsg(msg);
    }

}
