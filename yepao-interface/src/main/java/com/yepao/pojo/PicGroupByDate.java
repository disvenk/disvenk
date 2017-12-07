package com.yepao.pojo;

import java.util.List;

public class PicGroupByDate {
	
	private String dateString;
	
	private List<Picture> pictureList;
	

	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public List<Picture> getPictureList() {
		return pictureList;
	}
	public void setPictureList(List<Picture> pictureList) {
		this.pictureList = pictureList;
	}
	
}
