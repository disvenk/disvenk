package cn.itcast.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.CustomerRepository;
import cn.itcast.crm.domain.Customer;
import cn.itcast.crm.service.CustomerService;



@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	// 注入DAO
	@Autowired
	private CustomerRepository customerRepository;
	
	//查找未关联定区的客户
	@Override
	public List<Customer> findNoAssociationCustomers() {
		// fixedAreaId is null
		List<Customer> list = customerRepository.findByFixedAreaIdIsNull();
		return list;
	}

	//查找已关联定区的客户
	@Override
	public List<Customer> findHasAssociationFixedAreaCustomers(
			String fixedAreaId) {
		// fixedAreaId is ?
		return customerRepository.findByFixedAreaId(fixedAreaId);
	}

	//左右移动时的解除与关联
	@Override
	public void associationCustomersToFixedArea(String customerIdStr,
			String fixedAreaId) {

		// 因为前端通过左右移动客户的关联情况，所以为了避免重复关联，先解除所有客户关联
		customerRepository.clearFixedAreaId(fixedAreaId);
		System.out.println("已经清空了");
		//切割之前先判断是否为空，考虑到关联客户是会把右边的客户全部移动到左边，造成提交右边的option时，得到的是一个空数组
		if(customerIdStr.equals("null")) {
			//如果为空的话就直接结束本次方法
			System.out.println("执行了非空的判断");
			return;
		}
		// 切割字符串 1,2,3
		String[] customerIdArray = customerIdStr.split(",");
		for (String idStr : customerIdArray) {
			Integer id = Integer.parseInt(idStr);
			customerRepository.updateFixedAreaId(fixedAreaId, id);
		}
	}
	
	//保存新添加的客户
	@Override
	public void regist(Customer customer) {
		System.out.println(customer);
		customerRepository.save(customer);
	}
	
	//查询绑定额telephone的客户
	@Override
	public Customer findByTelephone(String telephone) {
		return customerRepository.findByTelephone(telephone);
	}
	
	//更新绑定type，这个是在dao层自定义的方法
	@Override
	public void updateType(String telephone) {
		customerRepository.updateType(telephone);
	}

	//客户登录注册
	@Override
	public Customer login(String telephone, String password) {
		return customerRepository.findByTelephoneAndPassword(telephone, password);
	}

	//根据地址获取定区编码
	@Override
	public String findFixedAreaIdByAddress(String address) {
		return customerRepository.findFixedAreaIdByAddress(address);
	}

	

}
