package cn.itcast.bos.service.transit.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.base.TransitInfoRepository;
import cn.itcast.bos.dao.base.WayBillRespository;
import cn.itcast.bos.domain.take_delivery.WayBill;
import cn.itcast.bos.domain.transit.TransitInfo;
import cn.itcast.bos.service.transit.TransitInfoService;

@Service
@Transactional
public class TransitInfoServiceImpl implements TransitInfoService{

	@Autowired
	private WayBillRespository wayBillRespository;
	
	@Autowired
	private TransitInfoRepository transitInfoRepository;
	
	@Override
	public void createTransits(String wayBillIds) {
		if(StringUtils.isNotBlank(wayBillIds)){
			//处理运单
			for(String wayBillId:wayBillIds.split(",")){
				WayBill persistWayBill = wayBillRespository.findOne(Integer.parseInt(wayBillId));
				//判断运单是否为待发货
				if(persistWayBill.getSignStatus()==1){
					//待发货
					//生成transitInfo信息
					TransitInfo transitInfo = new TransitInfo();
					//将运单保存到运输对象里面，表示该运单已经在运输当中了
					transitInfo.setWayBill(persistWayBill);
					transitInfo.setStatus("出入库中转");
					transitInfoRepository.save(transitInfo);
					
					//更改运单状态
					persistWayBill.setSignStatus(2);//运输中
					System.out.println("更新了运单的状态");
				}
			}
		}
	}

	//分页查询所有的运输信息
	@Override
	public Page<TransitInfo> findAll(Pageable pageable) {
		return transitInfoRepository.findAll(pageable);
	}
	
}
