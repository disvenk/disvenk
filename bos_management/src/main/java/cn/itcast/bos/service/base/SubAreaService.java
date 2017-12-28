package cn.itcast.bos.service.base;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import cn.itcast.bos.domain.base.Area;
import cn.itcast.bos.domain.base.SubArea;

public interface SubAreaService {
	// 批量保存区域实现
		public void saveBatch(List<SubArea> subAreas);

		// 条件分页查询
		public Page<SubArea> findPageData(Specification<SubArea> specification,
				Pageable pageable);

		void saveBatch(SubArea subArea);
		
		//查询区域
		public Area findByProvinceAndCityAndDistrict(String province,String city,String district);
}
