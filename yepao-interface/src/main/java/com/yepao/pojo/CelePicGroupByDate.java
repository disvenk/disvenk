package com.yepao.pojo;

import java.util.List;

public class CelePicGroupByDate {
	
	private String dateString;
	
	private List<CelebrationPicture> celePictureList;

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public List<CelebrationPicture> getCelePictureList() {
		return celePictureList;
	}

	public void setCelePictureList(List<CelebrationPicture> celePictureList) {
		this.celePictureList = celePictureList;
	}
	
	
}
