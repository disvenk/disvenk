package com.yepao.service;

import java.util.List;

import com.yepao.pojo.Dishstyle;

public interface DishStyleService {
	public List<Dishstyle> getDishStyleList(Long hotelId);
	public void addDishStyle(Dishstyle dishstyle);
	public Dishstyle getDishStyle(Long id);
	public void updateDishStyle(Dishstyle dishstyle);
	public void deleteDishStyle(Long id);
}
