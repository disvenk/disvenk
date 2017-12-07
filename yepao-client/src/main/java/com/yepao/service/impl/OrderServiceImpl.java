package com.yepao.service.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import com.other.pojo.OrderAsistant;
import com.pay.controller.ConstantStatus;
import com.websocket.controller.PointWebSocketHandler;
import com.yepao.mapper.AppointmentMapper;
import com.yepao.mapper.AppointmentPayedMapper;
import com.yepao.mapper.OrdersMapper;
import com.yepao.pojo.AppointmentPayed;
import com.yepao.pojo.BanquetHall;
import com.yepao.pojo.Orders;
import com.yepao.pojo.OrdersExample;
import com.yepao.pojo.OrdersExample.Criteria;
import com.yepao.service.OrderService;
import com.yepao.utils.JsonUtils;
import com.yepao.utils.YePaoResult;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private AppointmentPayedMapper appointmentPayedMapper;
	
	//未付款订单
	public List<Orders> getUnPayOrder(Long hotelId,String vaidateCode,Long id) {
		
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		criteria.andHotelIdEqualTo(hotelId);
		criteria.andStatusEqualTo("未付款");
		if(vaidateCode!=null && StringUtils.isNotBlank(vaidateCode)){
					criteria.andVaidateCodeEqualTo(vaidateCode);
				}
		if(id!=null){
			criteria.andIdEqualTo(id);
		}
		List<Orders> list = ordersMapper.selectByExample(example);
		return list;
	}

	//已付定金单
	public List<Orders> getPrePayOrder(Long hotelId,String vaidateCode,Long id) {
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		criteria.andHotelIdEqualTo(hotelId);
		criteria.andStatusEqualTo("已付定金");
		if(vaidateCode!=null && StringUtils.isNotBlank(vaidateCode)){
			criteria.andVaidateCodeEqualTo(vaidateCode);
		}
		if(id!=null){
			criteria.andIdEqualTo(id);
		}
				List<Orders> list = ordersMapper.selectByExample(example);
				return list;
			}

	//已付全款单
	public List<Orders> getPayed(Long hotelId,String vaidateCode,Long id) {
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		criteria.andHotelIdEqualTo(hotelId);
		criteria.andStatusEqualTo("已付全款");
		if(vaidateCode!=null && StringUtils.isNotBlank(vaidateCode)){
			criteria.andVaidateCodeEqualTo(vaidateCode);
		}
		if(id!=null){
			criteria.andIdEqualTo(id);
		}
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
		//顺带更改预约的宴会厅
		Orders orders2 = getOrders(orderId);
		AppointmentPayed apPayed = new AppointmentPayed();
		apPayed.setHotelId(orders2.getHotelId());
		//String hall = orders2.getHall().replace("\"", "\\\"");
		String hall = orders2.getHall();
		List<Object> jsonToList = JsonUtils.jsonToList(hall,Object.class);
		System.out.println(jsonToList);
		LinkedHashMap<String, Object> object =  (LinkedHashMap<String, Object>) jsonToList.get(0);
		List object2 = (List) object.get("itemName");
		LinkedHashMap<String, Object> object3 =  (LinkedHashMap<String, Object>) object2.get(0);
		
		apPayed.setHallId(Long.parseLong(object3.get("banquetHallId").toString()));
		apPayed.setHallName(object3.get("name").toString());
		apPayed.setCustomer(orders2.getCustomerName());
		apPayed.setTel(orders2.getTel());
		apPayed.setStatus("有效");
		apPayed.setTime(orders2.getReservedDate());
		apPayed.setCreated(new Date());
		
		appointmentPayedMapper.insert(apPayed);
		
		//发送消息
		new PointWebSocketHandler().sendMessageToUser(orders2.getHotelId(), new TextMessage(""));
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

	//查找单个订单
	@Override
	public Orders getOrders(Long ordersId) {
		
		return ordersMapper.selectByPrimaryKey(ordersId);
	}

	//UtoP
	@Override
	public YePaoResult uToP(Long id) {
		OrdersExample example = new OrdersExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIdEqualTo(id);
		Orders orders = new Orders();
		orders.setStatus(ConstantStatus.PRE_PAY);
		ordersMapper.updateByExampleSelective(orders, example);
		return YePaoResult.ok();
	}

	//PREtoP
	@Override
	public YePaoResult preToP(Long id) {
		OrdersExample example = new OrdersExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIdEqualTo(id);
		Orders orders = new Orders();
		orders.setStatus(ConstantStatus.PAY);
		ordersMapper.updateByExampleSelective(orders, example);
		return YePaoResult.ok();
	}

	
	
	
	

}
