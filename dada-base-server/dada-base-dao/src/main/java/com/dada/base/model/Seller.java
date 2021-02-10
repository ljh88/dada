package com.dada.base.model;

import java.io.Serializable;

/**
 * 商家实体类
 * @author lijinghua on 2019/9/9
 */
public class Seller implements Serializable {
    /**
     * 商家ID
     */
    private String sellerId;

    /**
     * 商家名称
     */
    private String sellerName;

    /**
     * 密码
     */
    private String password;

    /**
     * EMAIL
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态
     */
    private String status;

    /**
     * 详细地址
     */
    private String addressDetail;

    /**
     * 店铺LOGO图
     */
    private String logoPic;

    private static final long serialVersionUID = 1L;

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getLogoPic() {
        return logoPic;
    }

    public void setLogoPic(String logoPic) {
        this.logoPic = logoPic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sellerId=").append(sellerId);
        sb.append(", sellerName=").append(sellerName);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", mobile=").append(mobile);
        sb.append(", status=").append(status);
        sb.append(", addressDetail=").append(addressDetail);
        sb.append(", logoPic=").append(logoPic);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}