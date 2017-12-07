package com.yepao.service;

import java.util.List;

import com.other.pojo.Orders1;
import com.yepao.pojo.Orders;

public interface OrdersService {
	public List<Orders1> getOrderList(String openId,String status);
}
