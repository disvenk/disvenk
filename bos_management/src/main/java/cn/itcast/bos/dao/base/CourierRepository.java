package cn.itcast.bos.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.bos.domain.base.Courier;

public interface CourierRepository extends JpaRepository<Courier, Integer>,
		JpaSpecificationExecutor<Courier> {
	
	//批量还原的快递员的方法
	@Query(value = "update Courier set deltag='1' where id = ?")
	@Modifying
	public void updateDelTag(Integer id);
	
	@Query(value = "update Courier set deltag='0' where id = ?")
	@Modifying
	public void updateDelTag2(Integer id);

}
