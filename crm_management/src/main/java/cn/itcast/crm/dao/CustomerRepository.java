package cn.itcast.crm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.crm.domain.Customer;

public interface CustomerRepository extends JpaRepository</*就是靠这个来识别查询哪个表的*/Customer, Integer> {

	public Customer findByid(Integer id);
	//使用的jpa里面的查询规则，查询的是所有未关联定区的客户
	public List<Customer> findByFixedAreaIdIsNull();
	//也是使用jpa里面的查询规则，查询所有已关联定区的客户
	public List<Customer> findByFixedAreaId(String fixedAreaId);

	//将客户与定区关联
	@Query("update Customer set fixedAreaId = ? where id = ?")
	@Modifying
	public void updateFixedAreaId(String fixedAreaId, Integer id);

	//将选中的所有客户与定区接触关联
	@Query("update Customer set fixedAreaId = null where fixedAreaId = ?")
	@Modifying
	public void clearFixedAreaId(String fixedAreaId);
	
	//查询绑定了telephone的客户
	public Customer findByTelephone(String telephone);

	//在激活邮箱的时候，将当前已经绑定了邮箱的客户状态变成1，表示已经绑定
	@Query("update Customer set type=1 where telephone= ?")
	@Modifying
	public void updateType(String telephone);
	
	//客户登录查询
	public Customer findByTelephoneAndPassword(String telephone,String password);
	
	//根据地址获取定区编码
	@Query("select fixedAreaId from Customer where address=?")
	public String findFixedAreaIdByAddress(String address);

}