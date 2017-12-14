package com.yepao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mchange.v2.async.StrandedTaskReporting;
import com.yepao.mapper.OrderAlertMapper;
import com.yepao.mapper.OrdersMapper;
import com.yepao.pojo.OrderAlert;
import com.yepao.pojo.OrderAlertExample;
import com.yepao.pojo.Orders;
import com.yepao.pojo.OrdersExample;
import com.yepao.pojo.OrdersExample.Criteria;
import com.yepao.service.OrderAlertService;
import com.yepao.utils.YePaoResult;

@Service
public class OrderAlertServiceImpl implements OrderAlertService{

	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private OrderAlertMapper orderAlertMapper;
	
	//已付全款未查看的订单
	public List<Orders> getUnCheck() {
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		criteria.andCheckedEqualTo("未查看");
		criteria.andStatusEqualTo("已付全款");
		List<Orders> list = ordersMapper.selectByExample(example);
		return list;
	}

	//更改已付全款单为已查看
	public YePaoResult editorChecked(String ids) {
		
		String[] oids = ids.split(",");
		for (String string : oids) {
			Long id = Long.parseLong(string);
			OrdersExample example = new OrdersExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(id);
			Orders orders = new Orders();
			orders.setChecked("已查看");
			ordersMapper.updateByExampleSelective(orders, example);
		}
		return YePaoResult.ok();
	}

	//存储离线消息
	@Override
	public void saveOrderAlert(Long hotelId) {
		OrderAlert orderAlert = new OrderAlert();
		orderAlert.setHotelid(hotelId);
		orderAlert.setStatus("new");
		orderAlertMapper.insert(orderAlert);
		
	}

	//登录时查询离线消息
	@Override
	public YePaoResult getOrderAlert(Long hotelId) {
		OrderAlertExample example = new OrderAlertExample();
		com.yepao.pojo.OrderAlertExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andHotelidEqualTo(hotelId);
		createCriteria.andStatusEqualTo("new");
		List<OrderAlert> list = orderAlertMapper.selectByExample(example);
		if(list!=null && list.size()!=0){
			orderAlertMapper.updateLine(hotelId);
			return YePaoResult.ok();
		}
		return YePaoResult.build(400, "没有离线消息");
	}

}
