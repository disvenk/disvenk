package com.yepao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.OrdersMapper;
import com.yepao.pojo.Orders;
import com.yepao.pojo.OrdersExample;
import com.yepao.pojo.OrdersExample.Criteria;
import com.yepao.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrdersMapper ordersMapper;
	
	//未付款订单
	public List<Orders> getUnPayOrder() {
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo("未付款");
		List<Orders> list = ordersMapper.selectByExample(example);
		return list;
	}

	//已付定金单
	public List<Orders> getPrePayOrder() {
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo("已付定金");
		List<Orders> list = ordersMapper.selectByExample(example);
		return list;
	}

	//已付全款单
	public List<Orders> getPayed() {
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo("已付全款");
		List<Orders> list = ordersMapper.selectByExample(example);
		return list;
	}

}
