package com.yepao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.Orders;
import com.yepao.service.OrderAlertService;
import com.yepao.utils.YePaoResult;

@Controller
public class OrderAlertController {

	@Autowired
	private OrderAlertService orderAlertService;
	
	//查询未查看的已付全款订单
	@RequestMapping("/pay/orderAlert")
	@ResponseBody
	public List<Orders> getUnCheck(){
		List<Orders> unCheckList = orderAlertService.getUnCheck();
		return unCheckList;
	}

	//点击确认查看修改
	@RequestMapping("/editor/checked")
	@ResponseBody
	public YePaoResult editorChecked(String ids){
		YePaoResult result = orderAlertService.editorChecked(ids);
		return result;
	}
	
	//查询离线消息
	@RequestMapping("/checkOrderAlert")
	@ResponseBody
	public YePaoResult checkOrderAlert(Long hotelId){
		YePaoResult result = orderAlertService.getOrderAlert(hotelId);
		return result;
	}
}
