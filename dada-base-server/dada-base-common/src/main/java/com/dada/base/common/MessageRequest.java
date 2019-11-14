package com.dada.base.common;

import java.io.Serializable;
import java.util.Map;

public class MessageRequest implements Serializable {
    private static final long serialVersionUID = 9009536746362822147L;
    /**
     * 请求系统
     */
    private String requestModule;

    /**
     * 请求时间
     */
    private Long requestTime = System.currentTimeMillis();

    /**
     * 扩展字段
     */
    private Map<String, Object> ext;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getRequestModule() {
        return requestModule;
    }

    public void setRequestModule(String requestModule) {
        this.requestModule = requestModule;
    }

    public Long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Long requestTime) {
        this.requestTime = requestTime;
    }

    public Map<String, Object> getExt() {
        return ext;
    }

    public void setExt(Map<String, Object> ext) {
        this.ext = ext;
    }

    @Override
    public String toString() {
        return "MessageRequest{" +
                "requestModule='" + requestModule + '\'' +
                ", requestTime=" + requestTime +
                ", ext=" + ext +
                '}';
    }
}
