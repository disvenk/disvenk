package com.yepao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websocket.controller.PointWebSocketHandler;
import com.yepao.pojo.Orders;
import com.yepao.service.AppointmentPayService;
import com.yepao.service.OrderService;
import com.yepao.utils.YePaoResult;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private AppointmentPayService appointmentPayService;
	
	//未付款订单
	@RequestMapping("/unPayOrder")
	@ResponseBody
	public List<Orders> getUnPayOrder(Long hotelId,String vaidateCode,Long id){
		List<Orders> unPayOrder = orderService.getUnPayOrder(hotelId,vaidateCode,id);
		return unPayOrder;
	}
	
	//已付付定金单
	@RequestMapping("/prePayOrder")
	@ResponseBody
	public List<Orders> getPrePayOrder(Long hotelId,String vaidateCode,Long id){
		List<Orders> prePayOrder = orderService.getPrePayOrder(hotelId,vaidateCode,id);
		return prePayOrder;
	}
	
	//已付全款
	@RequestMapping("/payed")
	@ResponseBody
	public List<Orders> getPayedOrder(Long hotelId,String vaidateCode,Long id){
		List<Orders> payedOrder = orderService.getPayed(hotelId,vaidateCode,id);
		return payedOrder;
	}
	
	//延迟支付时使用
	//更改未付款订单为已付定金
	@RequestMapping("/unPayChangePay")
	@ResponseBody
	public YePaoResult unPayChangePay(Long unPayId){
		YePaoResult result = orderService.unPayChangePay(unPayId);
		
		return result;
	}
	
	//更改付定金单位付全款单
	@RequestMapping("/prePayChangePayed")
	@ResponseBody
	public YePaoResult prePayChangePayed(Long prePayId){
		YePaoResult result = orderService.prePayChangePayed(prePayId);
		return result;
	}
	
	//标记订单UtoP
	@RequestMapping("/signOrderUtoP")
	@ResponseBody
	public YePaoResult uToP(Long id){
		YePaoResult uToP = orderService.uToP(id);
		return uToP;
	}
	
	//标记订单UtoP
		@RequestMapping("/signOrderPREtoP")
		@ResponseBody
		public YePaoResult preToP(Long id){
			YePaoResult preToP = orderService.preToP(id);
			return preToP;
		}
	
}
