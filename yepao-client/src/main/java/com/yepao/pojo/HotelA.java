package com.yepao.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class HotelA {
	private Long id;
	
    private Long hotelId;

    private String password;
    
    private String name;

	private String address;

    private String descreption;

    private String tel;

    private String img;

    private BigDecimal reputationLevel;
    
    private Integer goodReputation;

    public Integer getGoodReputation() {
		return goodReputation;
	}

	public void setGoodReputation(Integer goodReputation) {
		this.goodReputation = goodReputation;
	}

	private Integer commentCount;

    private String insertDate;

    private Date updateDate;

    private String standby;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption == null ? null : descreption.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public BigDecimal getReputationLevel() {
        return reputationLevel;
    }

    public void setReputationLevel(BigDecimal reputationLevel) {
        this.reputationLevel = reputationLevel;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
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
