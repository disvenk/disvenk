package com.yepao.pojo;

import java.util.Date;

public class TalentReserved {
    private Long talentReservedId;

    private Long weddingTalentId;

    private Date reservedDate;

    private Long orderId;

    private Date createdDate;

    private Date updatedDate;

    public Long getTalentReservedId() {
        return talentReservedId;
    }

    public void setTalentReservedId(Long talentReservedId) {
        this.talentReservedId = talentReservedId;
    }

    public Long getWeddingTalentId() {
        return weddingTalentId;
    }

    public void setWeddingTalentId(Long weddingTalentId) {
        this.weddingTalentId = weddingTalentId;
    }

    public Date getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(Date reservedDate) {
        this.reservedDate = reservedDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}