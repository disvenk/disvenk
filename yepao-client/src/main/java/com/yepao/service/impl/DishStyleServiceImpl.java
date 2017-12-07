package com.yepao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.DishstyleMapper;
import com.yepao.pojo.Dishstyle;
import com.yepao.pojo.DishstyleExample;
import com.yepao.pojo.DishstyleExample.Criteria;
import com.yepao.service.DishStyleService;

@Service
public class DishStyleServiceImpl implements DishStyleService{

	@Autowired
	private DishstyleMapper dishstyleMapper;
	
	//查询菜品
	public List<Dishstyle> getDishStyleList(Long hotelId) {
		DishstyleExample example = new DishstyleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andHotelidEqualTo(hotelId);
		List<Dishstyle> list = dishstyleMapper.selectByExample(example);
		return list;
	}

	//添加菜品
	public void addDishStyle(Dishstyle dishstyle) {
		dishstyleMapper.insert(dishstyle);
		
	}

	//获取单个菜品
	public Dishstyle getDishStyle(Long id) {
		Dishstyle dishstyle = dishstyleMapper.selectByPrimaryKey(id);
		return dishstyle;
	}

	//更新菜品
	public void updateDishStyle(Dishstyle dishstyle) {
		dishstyleMapper.updateByPrimaryKey(dishstyle);
		
	}

	//删除菜品
	public void deleteDishStyle(Long id) {
		dishstyleMapper.deleteByPrimaryKey(id);
		
	}

}
