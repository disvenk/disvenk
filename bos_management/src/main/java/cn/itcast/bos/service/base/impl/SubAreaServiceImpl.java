package cn.itcast.bos.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import cn.itcast.bos.dao.base.AreaRepository;
import cn.itcast.bos.dao.base.SubAreaRespository;
import cn.itcast.bos.domain.base.Area;
import cn.itcast.bos.domain.base.SubArea;
import cn.itcast.bos.service.base.SubAreaService;

public class SubAreaServiceImpl implements SubAreaService {
	// 注入DAO
		@Autowired
		private SubAreaRespository subAreaRespository;
		@Autowired
		private AreaRepository areaRepository;

		@Override
		public void saveBatch(SubArea subArea) {
			
			subAreaRespository.save(subArea);
		}
		
		@Override
		public void saveBatch(List<SubArea> subAreas) {
			//dao的save方法里已经集成了集合的批量保存，所以传一个集合或者单个对象都可以保存
			subAreaRespository.save(subAreas);
		}

		@Override
		public Page<SubArea> findPageData(Specification<SubArea> specification,
				Pageable pageable) {
			return subAreaRespository.findAll(specification, pageable);
		}

		//查询区域
		@Override
		public Area findByProvinceAndCityAndDistrict(String province,
				String city, String district) {
			
			return areaRepository.findByProvinceAndCityAndDistrict(province, city, district);
		}
}
