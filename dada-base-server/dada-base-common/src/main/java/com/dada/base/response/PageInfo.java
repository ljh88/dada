package com.dada.base.response;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * 分页信息.
 * @version 1.0
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageInfo<T> implements Serializable {

    private long total;
    private List<T> list;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "{" +
                ", total:" + total +
                ", list:" + list +
                '}';
    }
}
