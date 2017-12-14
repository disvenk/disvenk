package com.yepao.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.other.pojo.CelebrationAsistant;
import com.other.pojo.OrderAsistant;
import com.other.pojo.Orders1;
import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLBoundFault;
import com.yepao.mapper.OrdersMapper;
import com.yepao.pojo.BanquetHall;
import com.yepao.pojo.Celebration;
import com.yepao.pojo.Combo;
import com.yepao.pojo.Orders;
import com.yepao.pojo.OrdersExample;
import com.yepao.pojo.WeddingTalent;
import com.yepao.pojo.OrdersExample.Criteria;
import com.yepao.service.CelebrationService;
import com.yepao.service.ComboService;
import com.yepao.service.HallService;
import com.yepao.service.OrdersService;
import com.yepao.utils.JsonUtils;

@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private HallService hallService;
	@Autowired
	private ComboService comboService;
	@Autowired
	private CelebrationService celebrationService;
	
	
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
			orders1.setTwoBarCode(orders.getTwoBarCode());
			orders1.setVaidateCode(orders.getVaidateCode());
			orders1.setReservedDate(orders.getReservedDate());
			//取hallJson
			String hallJson = orders.getHall();
			if(hallJson!=null && StringUtils.isNotBlank(hallJson)){
			List<OrderAsistant> hallList1 = JsonUtils.jsonToList(hallJson, OrderAsistant.class);
			OrderAsistant orderAsistant1 = hallList1.get(0);
			List<BanquetHall> hallList2 = new ArrayList<BanquetHall>();
			LinkedHashMap<String, Object> itemName1 = (LinkedHashMap<String, Object>) orderAsistant1.getItemName().get(0);
			Long hallId =Long.parseLong(itemName1.get("banquetHallId").toString()); 
			BanquetHall banquetHall = hallService.getBanquetHall(hallId);
			hallList2.add(banquetHall);
			orders1.setHall(hallList2);
			}
			
			//取菜品
			String comboJson = orders.getCombo();
			if(comboJson!=null && StringUtils.isNotBlank(comboJson)){
			List<OrderAsistant> comboList1 = JsonUtils.jsonToList(comboJson, OrderAsistant.class);
			OrderAsistant orderAsistant2 = comboList1.get(0);
			List<Combo> comboList2 = new ArrayList<Combo>();
			LinkedHashMap<String, Object> itemName2 = (LinkedHashMap<String, Object>) orderAsistant2.getItemName().get(0);
			System.out.println(itemName2);
			Long comboId =Long.parseLong(itemName2.get("id").toString()); 
			Combo combo = comboService.getCombo(comboId);
			combo.setCountTable(orderAsistant2.getNum());
			comboList2.add(combo);
			orders1.setCombo(comboList2);
			}
			
			//取庆典
			String celebraitonJson = orders.getCelebration();
			if(celebraitonJson!=null && StringUtils.isNotBlank(celebraitonJson)){
			List<CelebrationAsistant> celebrationList1 = JsonUtils.jsonToList(celebraitonJson, CelebrationAsistant.class);
			CelebrationAsistant celebrationAsistant = celebrationList1.get(0);
			List<Celebration> celebrationList2 = new ArrayList<Celebration>();
			LinkedHashMap<String, Object> itemName3 = (LinkedHashMap<String, Object>) celebrationAsistant.getItemName().get(0);
			Long celeId =Long.parseLong(itemName3.get("id").toString());
			Celebration celebration = celebrationService.getCelebration(celeId);
			celebration.setWelcome(null);
			celebration.setWeddingplace(null);
			celebration.setDesklight(null);
			celebration.setCeremony(null);
			Boolean isStage = celebrationAsistant.getStage();
			Boolean isLuxury = celebrationAsistant.isLuxury();
			if(isLuxury){
				celebration.setActualPrice(celebration.getPrice());
			}else{
				celebration.setActualPrice(celebration.getPreprice());
			}
			
			if(isStage){
				celebration.setStage("舞台全息一套");
			}else{
				celebration.setStage("不含舞台全息");
			}
			celebration.setComboName(celebrationAsistant.getComboName());
			celebrationList2.add(celebration);
			orders1.setCelebration(celebrationList2);
			}
			
			//取人才
			String talentJson = orders.getTalent();
			if(talentJson!=null && StringUtils.isNotBlank(talentJson)){
			List<WeddingTalent> talentList = JsonUtils.jsonToList(talentJson, WeddingTalent.class);
			orders1.setTalent(talentList);
			
			orders1.setObligation(orders.getObligation());
			orders1.setCount(orders.getCount());
			orders1.setCreated(orders.getCreated());
			}
			
			orders1s.add(orders1);
		}
		return orders1s;
	}

	
	

}
