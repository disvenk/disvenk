package cn.itcast.bos.service.transit.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.base.SignInfoRepository;
import cn.itcast.bos.dao.base.TransitInfoRepository;
import cn.itcast.bos.dao.indexRespository.WayBillIndexRespository;
import cn.itcast.bos.domain.transit.SignInfo;
import cn.itcast.bos.domain.transit.TransitInfo;
import cn.itcast.bos.service.transit.SignInfoService;

@Service
@Transactional
public class SignInfoServiceImpl implements SignInfoService {

	@Autowired
	private SignInfoRepository signInfoRepository;
	@Autowired
	private TransitInfoRepository transitInfoRepository;
	@Autowired
	private WayBillIndexRespository wayBillIndexRespository;
	
	@Override
	public void save(SignInfo signInfo, String transitInfoId) {
		//保存签收对象
		signInfoRepository.save(signInfo);
		
		//关联运输对象
		TransitInfo transitInfo = transitInfoRepository.findOne(Integer.parseInt(transitInfoId));
		transitInfo.setSignInfo(signInfo);
		
		//更改状态
		if(signInfo.getSignType().equals("正常")){
			//正常签收
			transitInfo.setStatus("正常签收");
			//更改运单状态
			transitInfo.getWayBill().setSignStatus(3);
			//更新索引库，如果设置定时更新索引库的任务就不用这么做了
			//wayBillIndexRespository.save(transitInfo.getWayBill());
		}else{
			//异常
			transitInfo.setStatus("异常");
			//更改运单状态
			transitInfo.getWayBill().setSignStatus(4);
			//更新索引库，如果设置定时更新索引库的任务就不用这么做了
			//wayBillIndexRespository.save(transitInfo.getWayBill());
		}
	}

}
