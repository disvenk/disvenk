package com.yepao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.ComboMapper;
import com.yepao.mapper.DishstyleMapper;
import com.yepao.pojo.Combo;
import com.yepao.pojo.ComboExample;
import com.yepao.pojo.ComboExample.Criteria;
import com.yepao.pojo.Dishstyle;
import com.yepao.service.ComboService;



@Service
public class ComboServiceImpl implements ComboService{

	@Autowired
	private ComboMapper comboMapper;
	@Autowired
	private DishstyleMapper dishstyleMapper;
	
	//查询菜肴菜单
	public List<Combo> getComboList(Long hotelId) {
		ComboExample example = new ComboExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andHotelidEqualTo(hotelId);
		List<Combo> list = comboMapper.selectByExample(example);
		return list;
	}

	//添加菜肴菜单
	public void addCombo(Combo combo) {
		comboMapper.insert(combo);
		
	}

	//获取单个套餐
	public Combo getCombo(Long id) {
		Combo combo = comboMapper.selectByPrimaryKey(id);
		return combo;
	}

	//更新菜肴套餐
	public void updateCombo(Combo combo) {
		comboMapper.updateByPrimaryKey(combo);
		
	}

	//删除菜肴套餐
	public void deleteCombo(Long id) {
		comboMapper.deleteByPrimaryKey(id);
		
	}

	//查找套餐关联的菜品
	public List<Dishstyle> getDishStyleByCombo(Long id) {
		Combo combo = comboMapper.selectByPrimaryKey(id);
		
		String ids = combo.getDishstyle();
		if(ids==null || ids.equals("")){
			return null;
		}
		String[] strings = ids.split(",");
		List<Dishstyle> list = new ArrayList<Dishstyle>();
		for (String string : strings) {
			Long did = Long.parseLong(string);
			Dishstyle dishstyle = dishstyleMapper.selectByPrimaryKey(did);
			list.add(dishstyle);
		}
		return list;
	}

	//关联菜品
	public void comboDishStyle(Long id,String[] ids) {
		String dIds = StringUtils.join(ids,",");
		ComboExample example = new ComboExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		Combo combo = new Combo();
		if(dIds==null){
			combo.setDishstyle("");
		}else {
			combo.setDishstyle(dIds);
		}
		
	
		comboMapper.updateByExampleSelective(combo, example);
		
	}

}
