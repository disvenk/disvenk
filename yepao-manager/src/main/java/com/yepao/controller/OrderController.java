package com.yepao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.Orders;
import com.yepao.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	//未付款订单
	@RequestMapping("/unPayOrder")
	@ResponseBody
	public List<Orders> getUnPayOrder(){
		List<Orders> unPayOrder = orderService.getUnPayOrder();
		return unPayOrder;
	}
	
	//已付付定金单
	@RequestMapping("/prePayOrder")
	@ResponseBody
	public List<Orders> getPrePayOrder(){
		List<Orders> prePayOrder = orderService.getPrePayOrder();
		return prePayOrder;
	}
	
	//已付全款
	@RequestMapping("/payed")
	@ResponseBody
	public List<Orders> getPayedOrder(){
		List<Orders> payedOrder = orderService.getPayed();
		return payedOrder;
	}
	
}
