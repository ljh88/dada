package com.dada.base.common;

public class DataResponse<T> extends MessageResponse{

    private static final long serialVersionUID = -3852472134412684597L;

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
        return "DataResponse{" +
                "data=" + data +
                '}';
    }
}
