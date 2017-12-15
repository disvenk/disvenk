package com.yepao.pojo;

import java.util.Date;

public class BanquetHall {
    private Long banquetHallId;

    private Long hotelid;

    private String name;

    private String floorNum;

    private String minTable;

    private String maxTable;

    private String floorHeight;

    private String area;

    private String img;

    private Date created;

    private Date updated;

    private String standby;

    public Long getBanquetHallId() {
        return banquetHallId;
    }

    public void setBanquetHallId(Long banquetHallId) {
        this.banquetHallId = banquetHallId;
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

    public String getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(String floorNum) {
        this.floorNum = floorNum == null ? null : floorNum.trim();
    }

    public String getMinTable() {
        return minTable;
    }

    public void setMinTable(String minTable) {
        this.minTable = minTable == null ? null : minTable.trim();
    }

    public String getMaxTable() {
        return maxTable;
    }

    public void setMaxTable(String maxTable) {
        this.maxTable = maxTable == null ? null : maxTable.trim();
    }

    public String getFloorHeight() {
        return floorHeight;
    }

    public void setFloorHeight(String floorHeight) {
        this.floorHeight = floorHeight == null ? null : floorHeight.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
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
    
    public String[] getImages(){
    	if(img!=null && !img.equals("")){
    		String[] images = img.split(",");
    		return images;
    	}
    		return null;
    }
}