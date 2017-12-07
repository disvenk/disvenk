package com.yepao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.other.pojo.CelebrationAsistant;
import com.other.pojo.OrderAsistant;
import com.other.pojo.Orders1;
import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLBoundFault;
import com.yepao.mapper.OrdersMapper;
import com.yepao.pojo.Orders;
import com.yepao.pojo.OrdersExample;
import com.yepao.pojo.WeddingTalent;
import com.yepao.pojo.OrdersExample.Criteria;
import com.yepao.service.OrdersService;
import com.yepao.utils.JsonUtils;

@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private OrdersMapper ordersMapper;
	
	
	/**
	 * 获得订单列表
	 */
	public List<Orders1> getOrderList(String openId,String status) {
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		criteria.andCustomerIdEqualTo(openId);
		criteria.andStatusEqualTo(status);
		example.setOrderByClause("`created` DESC");
		List<Orders> list = ordersMapper.selectByExample(example);
		
		List<Orders1> orders1s = new ArrayList<Orders1>();
		for (Orders orders : list) {
			Orders1 orders1 = new Orders1();
			orders1.setId(orders.getId());
			orders1.setVaidateCode(orders.getVaidateCode());
			orders1.setReservedDate(orders.getReservedDate());
			//取hallJson
			String hallJson = orders.getHall();
			List<OrderAsistant> hallList = JsonUtils.jsonToList(hallJson, OrderAsistant.class);
			orders1.setHall(hallList);
			
			//取菜品
			String comboJson = orders.getCombo();
			List<OrderAsistant> comboList = JsonUtils.jsonToList(hallJson, OrderAsistant.class);
			orders1.setCombo(comboList);
			
			//取庆典
			String celebraitonJson = orders.getCelebration();
			List<CelebrationAsistant> celebrationList = JsonUtils.jsonToList(celebraitonJson, CelebrationAsistant.class);
			orders1.setCelebration(celebrationList);
			
			//取人才
			String talentJson = orders.getTalent();
			List<WeddingTalent> talentList = JsonUtils.jsonToList(talentJson, WeddingTalent.class);
			orders1.setTalent(talentList);
			
			orders1.setPrepay(orders.getPrepay());
			orders1.setObligation(orders.getObligation());
			orders1.setCount(orders.getCount());
			orders1.setStatus(orders.getStatus());
			orders1.setCreated(orders.getCreated());
			orders1.setChecked(orders.getChecked());
			orders1.setPrepay(orders.getPrepay());
			orders1.setPayed(orders.getPayed());
			orders1.setClosed(orders.getClosed());
			
			orders1s.add(orders1);
		}
		return orders1s;
	}

	
	

}
