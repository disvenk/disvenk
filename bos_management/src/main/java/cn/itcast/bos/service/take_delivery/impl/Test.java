package cn.itcast.bos.service.take_delivery.impl;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.bos.dao.base.WayBillRespository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class Test {
		
	@Autowired
	private WayBillRespository wayBillRespository;
	@org.junit.Test
	public void test(){
		wayBillRespository.delete(282);
	}
}
