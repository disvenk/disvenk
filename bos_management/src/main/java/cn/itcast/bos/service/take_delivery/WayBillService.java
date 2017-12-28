package cn.itcast.bos.service.take_delivery;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.itcast.bos.domain.take_delivery.WayBill;

public interface WayBillService {

	//保存快速运单
	void save(WayBill wayBill);

	Page<WayBill> findPageData(WayBill wayBill,Pageable pageable);

	WayBill findByWayBillNum(String wayBillNum);
	
	//同步索引
	void syncIndex();

	//到处查询
	List<WayBill> findWayBills(WayBill model);
}
