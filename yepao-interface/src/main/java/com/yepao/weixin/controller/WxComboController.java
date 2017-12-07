package com.yepao.weixin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.Combo;
import com.yepao.pojo.Dishstyle;
import com.yepao.service.ComboService;

@Controller
@RequestMapping("/combo")
public class WxComboController {
	@Autowired
	private ComboService comboService;
	
	/**
	 * 获得套餐列表
	 * @return 套餐列表
	 */
	@RequestMapping("/comboList")
	@ResponseBody
	public List<Combo> getComboList(Long hotelId){
		List<Combo> list = comboService.getComboList(hotelId);
		return list;
	}
	
	/**
	 * 获得套餐详情
	 * @param comboId 套餐id
	 * @return 套餐详情
	 */
	@RequestMapping("/comboDetail")
	@ResponseBody
	public Map<String, Object> getComboDetail(Long comboId){
		System.out.println("comboId:"+comboId);
		Map<String, Object> comboDetailMap= comboService.getComboDetail(comboId);
		return comboDetailMap;
	}
}
