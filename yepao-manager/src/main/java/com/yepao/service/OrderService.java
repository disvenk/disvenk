package com.yepao.service;

import java.util.List;

import com.yepao.pojo.Orders;
import com.yepao.utils.YePaoResult;

public interface OrderService {
	//未付款订单
	public List<Orders> getUnPayOrder();
	//已付定金单
	public List<Orders> getPrePayOrder();
	//已付全款
	public List<Orders> getPayed();
	//添加未付款订单
	public void addUnPayOrder(Orders orders);
	//更改未付款单位已付定金单
	public YePaoResult unPayChangePay(Long orderId);
	//更改未付款单的预支付id为定金单的预支付id
	public void changePrePay_id(Long orderId,String prePay_id);
	//更改付定金单为已付全款单
	public YePaoResult prePayChangePayed(Long orderId);
}
