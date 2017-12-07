package com.yepao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.Orders;
import com.yepao.service.OrderService;
import com.yepao.utils.YePaoResult;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	//查询未付款订单
	@RequestMapping("/unPayOrder")
	@ResponseBody
	public List<Orders> getUnPayOrder(Long hotelId){
		List<Orders> unPayOrder = orderService.getUnPayOrder(hotelId);
		return unPayOrder;
	}
	
	//查询已付付定金单
	@RequestMapping("/prePayOrder")
	@ResponseBody
	public List<Orders> getPrePayOrder(Long hotelId){
		List<Orders> prePayOrder = orderService.getPrePayOrder(hotelId);
		return prePayOrder;
	}
	
	//查询已付全款
	@RequestMapping("/payed")
	@ResponseBody
	public List<Orders> getPayedOrder(Long hotelId){
		List<Orders> payedOrder = orderService.getPayed(hotelId);
		return payedOrder;
	}
	
	//延迟支付时使用
	//更改未付款订单为已付定金
	@RequestMapping("/unPayChangePay")
	@ResponseBody
	public YePaoResult unPayChangePay(Long out_trade_no){
		YePaoResult result = orderService.unPayChangePay(out_trade_no);
		return result;
	}
	
	//更改付定金单位付全款单
	@RequestMapping("/prePayChangePayed")
	@ResponseBody
	public YePaoResult prePayChangePayed(Long prePayId){
		YePaoResult result = orderService.prePayChangePayed(prePayId);
		return result;
	}
	
}
