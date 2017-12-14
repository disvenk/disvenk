package com.yepao.pojo;

import java.math.BigDecimal;

public class Celebration {
    private Long id;

    private Long hotelid;

    private String name;

    private String style;

    private String theme;

    private String basename;

    private BigDecimal preprice;

    private String img;

    private String isStage;

    private String comboStyle;

    private String comboname;

    private BigDecimal stagePrice;

    private BigDecimal price;

    private String welcome;

    private String ceremony;

    private String weddingplace;

    private String desklight;

    private String stageHolographic;

    private String standby;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHotelid() {
        return hotelid;
    }

    public void setHotelid(Long hotelid) {
        this.hotelid = hotelid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getBasename() {
        return basename;
    }

    public void setBasename(String basename) {
        this.basename = basename == null ? null : basename.trim();
    }

    public BigDecimal getPreprice() {
        return preprice;
    }

    public void setPreprice(BigDecimal preprice) {
        this.preprice = preprice;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getIsStage() {
        return isStage;
    }

    public void setIsStage(String isStage) {
        this.isStage = isStage == null ? null : isStage.trim();
    }

    public String getComboStyle() {
        return comboStyle;
    }

    public void setComboStyle(String comboStyle) {
        this.comboStyle = comboStyle == null ? null : comboStyle.trim();
    }

    public String getComboname() {
        return comboname;
    }

    public void setComboname(String comboname) {
        this.comboname = comboname == null ? null : comboname.trim();
    }

    public BigDecimal getStagePrice() {
        return stagePrice;
    }

    public void setStagePrice(BigDecimal stagePrice) {
        this.stagePrice = stagePrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome == null ? null : welcome.trim();
    }

    public String getCeremony() {
        return ceremony;
    }

    public void setCeremony(String ceremony) {
        this.ceremony = ceremony == null ? null : ceremony.trim();
    }

    public String getWeddingplace() {
        return weddingplace;
    }

    public void setWeddingplace(String weddingplace) {
        this.weddingplace = weddingplace == null ? null : weddingplace.trim();
    }

    public String getDesklight() {
        return desklight;
    }

    public void setDesklight(String desklight) {
        this.desklight = desklight == null ? null : desklight.trim();
    }

    public String getStageHolographic() {
        return stageHolographic;
    }

    public void setStageHolographic(String stageHolographic) {
        this.stageHolographic = stageHolographic == null ? null : stageHolographic.trim();
    }

    public String getStandby() {
        return standby;
    }

    public void setStandby(String standby) {
        this.standby = standby == null ? null : standby.trim();
    }
    
    public String[] getImages(){
    	if(img!=null){
    		return img.split(",");
    	}
    	return null;
    }
    
    public String getImage(){
    	if(img!=null){
    		return img.split(",")[0];
    	}
    	return null;
    }
    
    /*****************/
    private String stage;
    private String comboName;
    private BigDecimal actualPrice;

	public BigDecimal getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(BigDecimal actualPrice) {
		this.actualPrice = actualPrice;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getComboName() {
		return comboName;
	}

	public void setComboName(String comboName) {
		this.comboName = comboName;
	}
}