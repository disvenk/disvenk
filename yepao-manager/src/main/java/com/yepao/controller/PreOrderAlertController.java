package com.yepao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.Orders;
import com.yepao.service.PreOrderAlertService;
import com.yepao.utils.YePaoResult;

@Controller
public class PreOrderAlertController {

	@Autowired
	private PreOrderAlertService preOrderAlertService;
	
	//已付定金单
	@RequestMapping("/prepay/orderAlert")
	@ResponseBody
	public List<Orders> getPrePayOrder(){
		List<Orders> unCheck = preOrderAlertService.getUnCheck();
		return unCheck;
	}
	
	//点击确认查看修改
	@RequestMapping("/editor/preChecked")
	@ResponseBody
	public YePaoResult editorChecked(String ids){
		YePaoResult result = preOrderAlertService.editorChecked(ids);
		return result;
	}
}
