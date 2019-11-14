package com.dada.base.common;


public class PageInfoResponse<T> extends MessageResponse{

    private static final long serialVersionUID = 324569420936950506L;

    private PageInfo<T> pageInfo;

    public PageInfo<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }

    @Override
    public String toString() {
        return "PageInfoResponse{" +
                "pageInfo=" + pageInfo +
                '}';
    }
}
