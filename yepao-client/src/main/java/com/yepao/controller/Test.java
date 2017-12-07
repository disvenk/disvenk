package com.yepao.controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.field.DecoratedDateTimeField;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;

import com.other.pojo.OrderAsistant;
import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;
import com.websocket.controller.PointWebSocketHandler;
import com.yepao.pojo.BanquetHall;
import com.yepao.pojo.Orders;
import com.yepao.service.OrderService;
import com.yepao.service.impl.OrderServiceImpl;
import com.yepao.utils.FastDFSClient;
import com.yepao.utils.JsonUtils;
import com.yepao.utils.YePaoResult;

@Controller
public class Test {
	
	@RequestMapping("/test")
	public void test(){
		new PointWebSocketHandler().sendMessageToUser(13100738632L, new TextMessage(""));
	}
	
	@org.junit.Test
	public void test1(){
		StringBuilder str=new StringBuilder();//定义变长字符串
		Random random=new Random();
		//随机生成数字，并添加到字符串
		for(int i=0;i<8;i++){
		    str.append(random.nextInt(10));
		}
		//将字符串转换为数字并输出
		int num=Integer.parseInt(str.toString());
		System.out.println(num);
		
	}
}
