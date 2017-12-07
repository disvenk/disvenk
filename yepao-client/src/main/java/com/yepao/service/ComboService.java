package com.yepao.service;

import java.util.List;

import com.yepao.pojo.Combo;
import com.yepao.pojo.Dishstyle;

public interface ComboService {
	public List<Combo> getComboList(Long hotelId);
	public void addCombo(Combo combo);
	public Combo getCombo(Long id);
	public void updateCombo(Combo combo);
	public void deleteCombo(Long id);
	public List<Dishstyle> getDishStyleByCombo(Long id);
	public void comboDishStyle(Long id,String[] ids);
}
