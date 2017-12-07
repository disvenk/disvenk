package com.yepao.service;

import java.util.List;
import java.util.Map;

import com.yepao.pojo.Combo;
import com.yepao.pojo.Dishstyle;

public interface ComboService {
	public List<Combo> getComboList();
	public void addCombo(Combo combo);
	public Combo getCombo(Long id);
	public void updateCombo(Combo combo);
	public void deleteCombo(Long id);
	public List<Dishstyle> getDishStyleByCombo(Long id);
	public void comboDishStyle(Long id,String[] ids);
	
	//chen Xinneng below 
	//根据酒店id找到套餐列表
	public List<Combo> getComboList(Long hotelId);
	public Map<String,Object> getComboDetail(Long comboId);
}
