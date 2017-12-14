package com.yepao.weixin.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.other.pojo.Orders1;
import com.yepao.pojo.Orders;
import com.yepao.service.OrdersService;
import com.yepao.utils.CommonConstants;

@Controller
@RequestMapping("/order")
public class WxOrderController {
	
	@Autowired
	private OrdersService orderService;
	private Date reservedDate;
	
	
	
	
	
	/**
	 * 获得历史订单列表
	 * @return 套餐列表
	 */
	@RequestMapping("/histOrderList")
	@ResponseBody
	public List<Orders1> getHistOrderList(String openId){
		List<Orders1> list = orderService.getOrderList(openId,CommonConstants.COMMENTED);
		return list;
	}
	
	/**
	 * 获得预约单列表
	 * @return 预约单列表
	 */
	@RequestMapping("/reservedOrderList")
	@ResponseBody
	public List<Orders1> getReservedOrderList(String openId){
		List<Orders1> list = orderService.getOrderList(openId,CommonConstants.PRE_PAY);
		return list;
	}

	/**
	 * 获得待评价订单列表
	 * @return 待评价订单列表
	 */
	@RequestMapping("/allpaidOrderList")
	@ResponseBody
	public List<Orders1> getAllpaidOrderList(String openId){
		List<Orders1> list = orderService.getOrderList(openId,CommonConstants.PAY);
		return list;
	}

}
