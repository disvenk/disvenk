package com.yepao.service;

import java.util.List;

import com.yepao.pojo.Orders;

public interface OrderService {
	//未付款订单
	public List<Orders> getUnPayOrder();
	//已付定金单
	public List<Orders> getPrePayOrder();
	//已付全款
	public List<Orders> getPayed();
}
