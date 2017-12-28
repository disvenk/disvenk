package cn.itcast.bos.service.take_delivery.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.base.AreaRepository;
import cn.itcast.bos.dao.base.FixedAreaRepository;
import cn.itcast.bos.dao.base.OrderRepository;
import cn.itcast.bos.dao.base.WorkBillRespository;
import cn.itcast.bos.domain.base.Area;
import cn.itcast.bos.domain.base.Courier;
import cn.itcast.bos.domain.base.FixedArea;
import cn.itcast.bos.domain.base.SubArea;
import cn.itcast.bos.domain.constants.Constants;
import cn.itcast.bos.domain.take_delivery.Order;
import cn.itcast.bos.domain.take_delivery.WorkBill;
import cn.itcast.bos.service.take_delivery.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private FixedAreaRepository fixedAreaRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private AreaRepository areaRepository;
	
	
	//如果客户表里能查到的就使用客户表里的，如果查不到就匹配大区的
	@Override
	public void saveOrder(Order order) {
		
		System.out.println("进到保存订单的方法");
		
		order.setOrderTime(new Date());//设置下单时间
		order.setOrderNum(UUID.randomUUID().toString());//设置订单号
		order.setStatus("1");//待取件
		
		//获取到寄件人省市区
		//注意这里的Area对象是一个游离态的，它与order没有外键的关系，仅仅只是用来携带数据
		//特别注意的就是：之前我们在前端页面获取到的省市区搞成数组之后set到order里面，那是没有办法关联的，因为它没有id,所以
		//无法再最后保存订单的时候一起关联保存导数据表中，所以这里要提前查询，并装载到order中
		//寄件人省市区
		Area sendArea = order.getSendArea();
		//通过寄件人的省市区，到Area表里去查询到包含的省市区的Area对象，省市区的组合肯定是唯一的
		Area persistSendArea = areaRepository.findByProvinceAndCityAndDistrict(sendArea.getProvince()
				, sendArea.getCity(), sendArea.getDistrict());
		
		//收件人省市区
		Area recArea = order.getRecArea();
		//通过寄件人的省市区，到Area表里去查询到包含的省市区的Area对象，省市区的组合肯定是唯一的
		Area persistRecArea = areaRepository.findByProvinceAndCityAndDistrict(recArea.getProvince()
				, recArea.getCity(), recArea.getDistrict());
		
		//这里主要是让订单的区域字段，关联到区域表里的id，此前它不携带id，无法关联瞬时态的
		order.setSendArea(persistSendArea);
		order.setRecArea(persistRecArea);
		
		//自动分单逻辑，基于crm地址库完全匹配，获取定区，匹配快递员
		//客户表里有address和fixedAreaId两个字段，这里我们默认把寄件人详细地址认为是客户表里的address，
		//现在要用寄件人详细地址去客户表里查有没有这样的一个客户存在，如果存在则将他所关联的定区的定区编号返回
		String fixedAreaId = WebClient.create(Constants.CRM_MANAGEMENT_URL
				+"/crm_management/services/customerService/customer/findFixedAreaIdByAddress?address="
				+order.getSendAddress()).accept(MediaType.APPLICATION_JSON).get(String.class);
		//如果有两个客户在表中的地址都是是一样，都满足这个条件，那么返回的结果是一个数组，会不会报错
		
		//在客户中获得已关联的定区id后
		if(fixedAreaId!=null){
			//再用获取到的id去定区的表中查询具体的名称
			FixedArea fixedArea = fixedAreaRepository.findOne(fixedAreaId);
			//再查询出该定区中关联的所有快递员，一个定区可以关联多个快递员
			//这里有一个疑问：一个定区有很多的快递员，这样子我们每次都用的是第一个，是不是有点问题，也许这个遍历具有随机性吧呵呵呵
			Courier courier = fixedArea.getCouriers().iterator().next();
			if(courier!=null){
				//自动分单成功
				System.out.println("自动分单成功");
				//调用方法保存订单
				saveOrder(order, courier);
				
				//生成工单发送短信
				generateWorkBill(order);
				return;
			}
		}
		
		//自动分单逻辑，通过省市区，查询分区关键字，匹配地址，基于分区实现自动分单
		
		//关键字
		//得到这个区域的对象之后，得到里面的分区，进行遍历
		for (SubArea  subArea : persistSendArea.getSubareas()) {
			//当前登录客户下单地址中是否包含分区的关键字
			if(order.getSendAddress().contains(subArea.getKeyWords())){
				//如果订单中寄件人的地址中包含分区的关键字说明找到了分区，然后用找到定区，定区再找到快递员
				// 找到分区 ,找到定区、找到快递员
				Iterator<Courier> iterator = subArea.getFixedArea()
						.getCouriers().iterator();
				if (iterator.hasNext()) {
					Courier courier = iterator.next();
					if (courier != null) {
						// 自动分单成功
						System.out.println("自动分单成功....");
						saveOrder(order, courier);
					
					//生成工单发送短信
					generateWorkBill(order);
				}
			}
		}
		}
		
		//辅助关键字
		//区域表示大区，定区表示多个某某路合成的配送范围，分区表示某某路，某某大道，某某街
		for (SubArea subArea : persistSendArea.getSubareas()) {
			// 当前客户的下单地址 是否包含分区 辅助关键字
			if (order.getSendAddress().contains(subArea.getAssistKeyWords())) {
				// 找到分区 ,找到定区、找到快递员
				Iterator<Courier> iterator = subArea.getFixedArea()
						.getCouriers().iterator();
				if (iterator.hasNext()) {
					Courier courier = iterator.next();
					if (courier != null) {
						// 自动分单成功
						System.out.println("自动分单成功....");
						saveOrder(order, courier);

						// 生成工单 发送短信
						generateWorkBill(order);

						return;
					}
				}

			}
		}
		//进入人工分单
		order.setOrderType("2");
		orderRepository.save(order);
}

	@Autowired
	private WorkBillRespository workBillRespository;
	@Autowired
	@Qualifier("jmsQueueTemplate")
	private JmsTemplate jmsTemplate;
	
	private void generateWorkBill(final Order order) {
		//生成工单
		WorkBill workBill = new WorkBill();
		workBill.setType("新");//工单类型，新单
		workBill.setPickstate("新单");//取件状态，新单
		workBill.setBuildtime(new Date());//工单生成时间
		workBill.setRemark(order.getRemark());//订单备注
		final String smsNumber = RandomStringUtils.randomNumeric(4);
		workBill.setSmsNumber(smsNumber);//设置短信序号
		workBill.setOrder(order);//关联订单
		workBill.setCourier(order.getCourier());//关联快递员
		workBillRespository.save(workBill);//保存工单
		
		//发送短信
		//调用mq发送一条短信
		jmsTemplate.send("bos_sms"/*队列的名字*/, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				//有session对象得到一个MapMessage对象
				//使用mapMessage可以存储多个键值对的数据
				MapMessage mapMessage = session.createMapMessage();
				mapMessage.setString("telephone", order.getCourier()
						.getTelephone());
				mapMessage.setString("msg", "短信序号"
						+smsNumber+"，取件地址："+order.getSendAddress()
						+"，联系人："+order.getSendName()+"，手机"
						+order.getSendMobile()+"，快递员捎话"
						+order.getSendMobileMsg());
				return mapMessage;
			}
		});
		
		//修改工单状态
		workBill.setPickstate("已通知");
	}


	private void saveOrder(Order order, Courier courier) {
		//将快递员关联在订单上
		order.setCourier(courier);
		//保存订单
		//先生成一个定单号
		order.setOrderType("1");
		orderRepository.save(order);
	}


	//运单回显查询
	@Override
	public Order findByOrderNum(String orderNum) {
		return orderRepository.findByOrderNum(orderNum);
	}
	
	
}
