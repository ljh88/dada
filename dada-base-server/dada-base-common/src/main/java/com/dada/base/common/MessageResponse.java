package com.dada.base.common;

import com.dada.base.enums.ErrorCode;

import java.io.Serializable;
import java.util.Map;

public class MessageResponse implements Serializable {

    /**
     * 状态码
     */
    private String responseCode = ErrorCode.SUCCEESS.getCode();

    /**
     * 状态描述
     */
    private String responseDesc = ErrorCode.SUCCEESS.getDesc();

    /**
     * 扩展字段
     */
    private Map<String, Object> ext;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    public Map<String, Object> getExt() {
        return ext;
    }

    public void setExt(Map<String, Object> ext) {
        this.ext = ext;
    }

    @Override
    public String toString() {
        return "MessageResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseDesc='" + responseDesc + '\'' +
                ", ext=" + ext +
                '}';
    }
}
