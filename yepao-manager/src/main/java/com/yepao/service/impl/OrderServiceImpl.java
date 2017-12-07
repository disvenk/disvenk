package com.yepao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.controller.ConstantStatus;
import com.yepao.mapper.OrdersMapper;
import com.yepao.pojo.Orders;
import com.yepao.pojo.OrdersExample;
import com.yepao.pojo.OrdersExample.Criteria;
import com.yepao.service.OrderService;
import com.yepao.utils.YePaoResult;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrdersMapper ordersMapper;
	
	//未付款订单
	public List<Orders> getUnPayOrder(Long hotelId) {
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo("未付款");
		criteria.andHotelIdEqualTo(hotelId);
		List<Orders> list = ordersMapper.selectByExample(example);
		return list;
	}

	//已付定金单
	public List<Orders> getPrePayOrder(Long hotelId) {
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo("已付定金");
		criteria.andHotelIdEqualTo(hotelId);
		List<Orders> list = ordersMapper.selectByExample(example);
		return list;
	}

	//已付全款单
	public List<Orders> getPayed(Long hotelId) {
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo("已付全款");
		criteria.andHotelIdEqualTo(hotelId);
		List<Orders> list = ordersMapper.selectByExample(example);
		return list;
	}

	//添加未付款订单
	public void addUnPayOrder(Orders orders) {
		ordersMapper.insert(orders);
		
	}

	//更改未付款单为已付定金单
	public YePaoResult unPayChangePay(Long orderId) {
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(orderId);
		Orders orders = new Orders();
		orders.setStatus(ConstantStatus.PRE_PAY);
		ordersMapper.updateByExampleSelective(orders, example);
		return YePaoResult.ok();
	}
	
	//更改未付款单的预支付id为定金单的预支付id
	public void changePrePay_id(Long orderId, String prePay_id) {
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(orderId);
		Orders orders = new Orders();
		orders.setPrepayId(prePay_id);
		ordersMapper.updateByExampleSelective(orders, example);
	}

	//更改付定金单为已付全款单
	public YePaoResult prePayChangePayed(Long orderId) {
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(orderId);
		Orders orders = new Orders();
		orders.setStatus(ConstantStatus.PAY);
		ordersMapper.updateByExampleSelective(orders, example);
		return YePaoResult.ok();
	}

	
	
	
	

}
