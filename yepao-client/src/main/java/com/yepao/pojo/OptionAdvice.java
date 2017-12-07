package com.yepao.pojo;

import java.util.Date;

public class OptionAdvice {
    private Long optionAdviceId;

    private Long hotelid;

    private String weixinName;

    private String commentContent;

    private Date submitDate;

    private Date updateDate;

    private String standby;

    public Long getOptionAdviceId() {
        return optionAdviceId;
    }

    public void setOptionAdviceId(Long optionAdviceId) {
        this.optionAdviceId = optionAdviceId;
    }

    public Long getHotelid() {
        return hotelid;
    }

    public void setHotelid(Long hotelid) {
        this.hotelid = hotelid;
    }

    public String getWeixinName() {
        return weixinName;
    }

    public void setWeixinName(String weixinName) {
        this.weixinName = weixinName == null ? null : weixinName.trim();
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getStandby() {
        return standby;
    }

    public void setStandby(String standby) {
        this.standby = standby == null ? null : standby.trim();
    }
}