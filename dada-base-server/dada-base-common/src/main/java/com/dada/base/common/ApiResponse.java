/*
 * @(#)MessageResponse.java 1.0  2017/9/7
 *
 * Copyright 2017-2027 JR All Rights Reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * Author Email: wywanxiaowei@jd.com
 */


package com.dada.base.common;

import com.alibaba.fastjson.JSON;

/**
 * 响应对象定义.
 *
 * @param <T> the type parameter
 * @author wywanxiaowei
 * @version 1.0, 2017-09-07
 */
public class ApiResponse<T> {


    public ApiResponse() {
    }

    public ApiResponse(T t) {
        this.data = t;
    }

    public ApiResponse(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    /**
     * 获取响应码.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置响应码.
     *
     * @param code 响应码
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 获取响应描述.
     *
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置响应描述.
     *
     * @param msg the msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取报文数据实体.
     *
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * 设置报文数据实体.
     *
     * @param data the data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * 响应码.
     */
    private int code = ApiConstants.API_SUCCESS;

    /**
     * 响应描述.
     */
    private String msg = ApiConstants.API_SUCCESS_MSG;
    /**
     * 报文数据实体.
     */
    private T data;

    /**
     * 返回成功json，带数据对象
     * @param <T>
     * @return
     */
    public static <T> String buildJson(T data) {
        return JSON.toJSONString(new ApiResponse<T>(data));
    }

    /**
     * 返回成功json，不带数据对象
     * @param <T>
     * @return
     */
    public static <T> String buildJson() {
        return JSON.toJSONString(new ApiResponse<T>());
    }

    /**
     * 返回json，自定义code&message
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> String buildJson(int code, String message) {
        return JSON.toJSONString(new ApiResponse<T>(code, message));
    }

    /**
     * 返回失败，接口必传参数为空
     * @return
     */
    public static String buildErrorJson(){
        return JSON.toJSONString(new ApiResponse(ApiConstants.SYSTEM_ERROR, "必填字段为空"));
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ApiResponse{");
        sb.append("code=").append(code);
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}

