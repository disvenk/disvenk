package com.yepao.pojo;

import java.util.Date;

public class ComboComment {
    private Long comboId;

    private Long customerId;

    private String commentContent;

    private Integer compLevel;

    private String img;

    private Date created;

    public Long getComboId() {
        return comboId;
    }

    public void setComboId(Long comboId) {
        this.comboId = comboId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Integer getCompLevel() {
        return compLevel;
    }

    public void setCompLevel(Integer compLevel) {
        this.compLevel = compLevel;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}