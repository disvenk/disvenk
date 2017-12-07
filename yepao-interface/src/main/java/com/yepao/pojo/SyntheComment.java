package com.yepao.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class SyntheComment {
    private Long id;

    private String nickName;

    private Long customerId;

    private Long orderId;

    private BigDecimal compLevel;

    private Date createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getCompLevel() {
        return compLevel;
    }

    public void setCompLevel(BigDecimal compLevel) {
        this.compLevel = compLevel;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}