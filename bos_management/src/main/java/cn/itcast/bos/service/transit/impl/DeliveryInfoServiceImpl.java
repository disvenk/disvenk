package cn.itcast.bos.service.transit.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.base.DeliveryRepository;
import cn.itcast.bos.dao.base.TransitInfoRepository;
import cn.itcast.bos.domain.transit.DeliveryInfo;
import cn.itcast.bos.domain.transit.TransitInfo;
import cn.itcast.bos.service.transit.DeliveryInfoService;

@Service
@Transactional
public class DeliveryInfoServiceImpl implements DeliveryInfoService {

	@Autowired
	private TransitInfoRepository transitInfoRepository;
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	//保存配送信息对象
	@Override
	public void save(DeliveryInfo deliveryInfo, String transitInfoId) {
		//保存配送信息
		deliveryRepository.save(deliveryInfo);
		
		//查询运输信息对象
		TransitInfo transitInfo = transitInfoRepository.findOne(Integer.parseInt(transitInfoId));
		
		//将配送信息关联到运输信息对象
		transitInfo.setDeliveryInfo(deliveryInfo);
		
		//更改运输信息对象的配送状态
		transitInfo.setStatus("开始配送");
		
	}

}
