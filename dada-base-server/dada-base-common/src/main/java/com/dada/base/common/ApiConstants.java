/*
 * @(#)Constants  1.0 2017/10/16
 *
 * Copyright 2014-2019 chinabank payment All Rights Reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * Author Email: heke@jd.com
 */

package com.dada.base.common;

/**
 * api子模块常量类
 */
public class ApiConstants {

    /**
     * api接口请求成功
     */
    public final static String API_SUCCESS = "0";
    public final static String API_SUCCESS_MSG = "success";

    /**
     * api接口请求失败，客户端正常处理往下流程
     * 根据返回实体内的resCode走不同流程
     */
    public final static String API_FAIL = "1";
    public final static String API_FAIL_MSG = "fail";

    /**
     * 接口超时 客户端处理为弹框，文案内容为：连接超时，请稍后再试
     */
    public final static String SYSTEM_ERROR = "-1";
    public final static String SYSTEM_ERROR_MSG = "系统异常";

    /**
     * http请求produces
     */
    public static final String HTTP_REQUEST_PRODUCES = "application/json;charset=utf-8";
}
