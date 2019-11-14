package com.dada.base.common;

/**
 *携带数据的请求
 */
public class DataRequest<T> extends MessageRequest {
    private static final long serialVersionUID = 9009536746362822146L;

    /**
     * 携带数据
     */
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataRequest{" +
                "data=" + data +
                '}';
    }
}
