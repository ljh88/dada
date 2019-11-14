package com.dada.base.enums;

import java.io.Serializable;

/**
 * 错误码
 */
public enum ErrorCode implements Serializable {

    SUCCEESS("00000","成功"),
    UNKNOWN_ERROR("0099999", "系统开小差了"),

    // 01 数据库异常
    DATABASE_ERROR("COM0100001", "数据库异常"),
    CACHE_ERROR("COM0100002", "缓存异常"),

    // 02 网络异常
    RPC_CONN_ERROR("COM0200001", "RPC服务调用异常."),
    RPC_CODE_ERROR("COM0200002", "RPC服务调用返回错误."),
    NET_CONN_ERROR("COM0200003", "HTTP服务连接异常."),

    EMPTY("empty", "请求字段为空"),
    EMPTY_REQUEST("empty_request", "请求参数为空"),;



    ErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;

    private String desc;

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

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }}
