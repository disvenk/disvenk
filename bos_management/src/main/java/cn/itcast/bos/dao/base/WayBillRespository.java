package cn.itcast.bos.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.itcast.bos.domain.take_delivery.WayBill;

public interface WayBillRespository extends JpaRepository<WayBill, Integer>,
		JpaSpecificationExecutor<WayBill>{

	WayBill findByWayBillNum(String wayBillNum);

}
