package com.other.pojo;

import java.util.List;

public class CelebrationAsistant {
	private String ComboName;
	private boolean isStage;
	private List itemName;
	private boolean luxury;
	
	public boolean isLuxury() {
		return luxury;
	}
	public void setLuxury(boolean luxury) {
		this.luxury = luxury;
	}
	public String getComboName() {
		return ComboName;
	}
	public void setComboName(String comboName) {
		ComboName = comboName;
	}
	public boolean isStage() {
		return isStage;
	}
	public void setStage(boolean isStage) {
		this.isStage = isStage;
	}
	public List getItemName() {
		return itemName;
	}
	public void setItemName(List itemName) {
		this.itemName = itemName;
	}
	
	
}
