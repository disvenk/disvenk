package cn.itcast.crm.service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.crm.domain.Customer;
import cn.itcast.crm.service.CustomerService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class Tests {
	
	@Autowired
	private CustomerService customerService;
		@Test
		public void test(){
			List<Customer> list = customerService.findNoAssociationCustomers();
			System.out.println("到此一游");
			System.out.println(list);
		}
		
}
