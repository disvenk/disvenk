package cn.itcast.bos.service.transit;

import cn.itcast.bos.domain.transit.DeliveryInfo;

public interface DeliveryInfoService {

	void save(DeliveryInfo deliveryInfo, String transitInfoId);

}
