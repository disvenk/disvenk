package cn.itcast.bos.service.transit.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.base.InOutStorageInfoRepository;
import cn.itcast.bos.dao.base.TransitInfoRepository;
import cn.itcast.bos.domain.transit.InOutStorageInfo;
import cn.itcast.bos.domain.transit.TransitInfo;
import cn.itcast.bos.service.transit.InOutStorageInfoService;

@Service
@Transactional
public class InOutStorageInfoServiceImpl implements InOutStorageInfoService {

	@Autowired
	private InOutStorageInfoRepository inOutStorageInfoRepository;
	@Autowired
	private TransitInfoRepository transitInfoRepository;
	
	//保存出入信息
	@Override
	public void save(InOutStorageInfo inOutStorageInfo, String transitInfoId) {
		//保存出入库信息
		inOutStorageInfoRepository.save(inOutStorageInfo);
		
		//查询TransitInfo
		TransitInfo transitInfo = transitInfoRepository.findOne(Integer.parseInt(transitInfoId));
		
		//将出入库对象关联到运输配送对象
		transitInfo.getInOutStorageInfos().add(inOutStorageInfo);
		
		//修改运输状态，如果到达网点就无需在运输
		if(inOutStorageInfo.getOperation().equals("到达网点")){
			transitInfo.setStatus("到达网点");
			//更新网点地址，显示配送路径
			transitInfo.setOutletAddress(inOutStorageInfo.getAddress());
		}
	}

}
