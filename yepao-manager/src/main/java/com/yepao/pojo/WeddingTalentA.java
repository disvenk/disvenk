package com.yepao.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class WeddingTalentA {
	 private Long weddingTalentId;

	    private String headImg;

	    private String name;

	    private String occupation;

	    private Integer experience;

	    private String tel;

	    private BigDecimal price;

	    private String introduction;

	    private String style;

	    private String goodReputation;

	    private Integer comprehensive;

	    private Integer chosenCount;

	    private String created;

	    private Date updated;

	    private String standby;

	    public Long getWeddingTalentId() {
	        return weddingTalentId;
	    }

	    public void setWeddingTalentId(Long weddingTalentId) {
	        this.weddingTalentId = weddingTalentId;
	    }

	    public String getHeadImg() {
	        return headImg;
	    }

	    public void setHeadImg(String headImg) {
	        this.headImg = headImg == null ? null : headImg.trim();
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name == null ? null : name.trim();
	    }

	    public String getOccupation() {
	        return occupation;
	    }

	    public void setOccupation(String occupation) {
	        this.occupation = occupation == null ? null : occupation.trim();
	    }

	    public Integer getExperience() {
	        return experience;
	    }

	    public void setExperience(Integer experience) {
	        this.experience = experience;
	    }

	    public String getTel() {
	        return tel;
	    }

	    public void setTel(String tel) {
	        this.tel = tel == null ? null : tel.trim();
	    }

	    public BigDecimal getPrice() {
	        return price;
	    }

	    public void setPrice(BigDecimal price) {
	        this.price = price;
	    }

	    public String getIntroduction() {
	        return introduction;
	    }

	    public void setIntroduction(String introduction) {
	        this.introduction = introduction == null ? null : introduction.trim();
	    }

	    public String getStyle() {
	        return style;
	    }

	    public void setStyle(String style) {
	        this.style = style == null ? null : style.trim();
	    }

	    public String getGoodReputation() {
	        return goodReputation;
	    }

	    public void setGoodReputation(String goodReputation) {
	        this.goodReputation = goodReputation == null ? null : goodReputation.trim();
	    }

	    public Integer getComprehensive() {
	        return comprehensive;
	    }

	    public void setComprehensive(Integer comprehensive) {
	        this.comprehensive = comprehensive;
	    }

	    public Integer getChosenCount() {
	        return chosenCount;
	    }

	    public void setChosenCount(Integer chosenCount) {
	        this.chosenCount = chosenCount;
	    }

	    public String getCreated() {
	        return created;
	    }

	    public void setCreated(String created) {
	        this.created = created;
	    }

	    public Date getUpdated() {
	        return updated;
	    }

	    public void setUpdated(Date updated) {
	        this.updated = updated;
	    }

	    public String getStandby() {
	        return standby;
	    }

	    public void setStandby(String standby) {
	        this.standby = standby == null ? null : standby.trim();
	    }
}
