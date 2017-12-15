package com.other.pojo;

import java.util.Date;

public class TalentComment1 {
    private Long id;

    private String nickName;

    private String customerId;

    private String talentName;

    public String getTalentId() {
		return talentId;
	}

	public void setTalentId(String talentId) {
		this.talentId = talentId;
	}

	public String getCompLevel() {
		return compLevel;
	}

	public void setCompLevel(String compLevel) {
		this.compLevel = compLevel;
	}

	private String talentId;

    private String commentContent;

    private String compLevel;

    private String img;

    private Date created;

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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTalentName() {
        return talentName;
    }

    public void setTalentName(String talentName) {
        this.talentName = talentName == null ? null : talentName.trim();
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
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