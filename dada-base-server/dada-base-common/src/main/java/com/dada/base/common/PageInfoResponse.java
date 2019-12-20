package com.dada.base.common;


public class PageInfoResponse<T> extends MessageResponse{

    private static final long serialVersionUID = 324569420936950506L;

    private String code = "100";

    private String msg = "成功";

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private PageInfo<T> pageInfo = new PageInfo<>();

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
    public static PageInfoResponse newPageInfoResponse(String code, String desc) {
        PageInfoResponse pageInfoResponse = new PageInfoResponse();
        pageInfoResponse.setCode(code);
        pageInfoResponse.setMsg(desc);
        pageInfoResponse.setPageInfo(new PageInfo());
        return pageInfoResponse;
    }
}
