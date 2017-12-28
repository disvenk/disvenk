package cn.itcast.bos.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.base.AreaRepository;
import cn.itcast.bos.domain.base.Area;
import cn.itcast.bos.service.base.AreaService;

@Service
@Transactional
public class AreaServiceImpl implements AreaService {

	// 注入DAO
	@Autowired
	private AreaRepository areaRepository;

	@Override
	public void saveBatch(Area area) {
		
		areaRepository.save(area);
	}
	
	@Override
	public void saveBatch(List<Area> areas) {
		//dao的save方法里已经集成了集合的批量保存，所以传一个集合或者单个对象都可以保存
		areaRepository.save(areas);
	}

	@Override
	public Page<Area> findPageData(Specification<Area> specification,
			Pageable pageable) {
		return areaRepository.findAll(specification, pageable);
	}

}
