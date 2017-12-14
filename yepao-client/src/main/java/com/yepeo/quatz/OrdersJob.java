package com.yepeo.quatz;



import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.yepao.mapper.AppointmentPayedMapper;
import com.yepao.mapper.OrdersMapper;
import com.yepao.pojo.Orders;
import com.yepao.pojo.OrdersExample;
import com.yepao.pojo.OrdersExample.Criteria;
import com.yepao.service.AppointmentPayService;


public class OrdersJob implements Job {

	//无法注入的问题是说，当前这个类并没有没spring管理，它要注入被spring管理的类是无法成功的
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private AppointmentPayedMapper apMapper;
	
	
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		OrdersExample example = new OrdersExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusEqualTo("未付款");
		List<Orders> list = ordersMapper.selectByExample(example);
		Long time = new Date().getTime();
		for (Orders orders : list) {
			long time2 = orders.getClosed().getTime();
			if(time>time2){
				ordersMapper.updateStatus(orders.getId());
				apMapper.updateStatus(orders.getId());
			}
				
		}
		System.out.println("执行订单失效和宴会厅预定失效");
		
	}

}
