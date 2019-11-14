package com.dada.base.common;


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
    private int pageNum;
    private int pageSize;
    private long total;
    private List<T> list;

    public PageInfo() {
        //默认页码1， 一页显示10条记录
        this(1, 10);
    }

    public PageInfo(int pageNum, int pageSize) {
        this(pageNum, pageSize, pageSize);
    }

    public PageInfo(int pageNum, int pageSize, long total) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
    }

    public PageInfo(PageInfo pageInfo, List<T> list) {
        if (pageInfo != null) {
            this.pageNum = pageInfo.getPageNum();
            this.pageSize = pageInfo.getPageSize();
            this.total = pageInfo.getTotalElements();
        }

        this.list = list;
    }

    public PageInfo(PageInfo<T> pageInfo) {
        if (pageInfo != null) {
            this.pageNum = pageInfo.getPageNum();
            this.pageSize = pageInfo.getPageSize();
            this.total = pageInfo.getTotalElements();
            this.list = pageInfo.getList();
        }
    }


    /**
     * @param pageNum
     */
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum <= 0 ? 1 : pageNum;
    }

    /**
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize <= 0 ? 10 : pageSize;
    }

    /**
     * @return list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * @param list
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * @param total
     */
    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getOffset() {
        return (pageNum - 1) * pageSize;
    }

    public int getTotalPages() {
        return getPageSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getPageSize());
    }

    public long getTotalElements() {
        return total;
    }

    public PageInfo next() {
        return new PageInfo(getPageNum() + 1, getPageSize(), getTotalElements());
    }

    public PageInfo previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    public PageInfo previous() {
        return getPageNum() == 1 ? this : new PageInfo(getPageNum() - 1, getPageSize(), getTotalElements());
    }
    public PageInfo first() {
        return new PageInfo(1, getPageSize(), getTotalElements());
    }

    public boolean hasPrevious() {
        return pageNum > 1;
    }

    public boolean hasNext() {
        return getPageNum() < getTotalPages();
    }

    public boolean isLast() {
        return !hasNext();
    }

    public void setPage(int page) {
        setPageNum(page);
    }

    public void setRows(int rows) {
        setPageSize(rows);
    }

    public int getPage() {
        return getPageNum();
    }

    public int getRows() {
        return getPageSize();
    }

    public static <T> PageInfo<T> newPageInfo(PageInfo pageInfo, List<T> list) {
        return new PageInfo<T>(pageInfo, list);
    }

    public static <T> PageInfo<T> newPageInfo(int pageNum, int pageSize, long total) {
        return new PageInfo<T>(pageNum, pageSize, total);
    }

    public static <T> PageInfo<T> newPageInfo(int pageNum, int pageSize) {
        return new PageInfo<T>(pageNum, pageSize);
    }

    @Override
    public String toString() {
        return "{" + "pageNum:" + pageNum +
                ", pageSize:" + pageSize +
                ", total:" + total +
                ", list:" + list +
                '}';
    }
}
