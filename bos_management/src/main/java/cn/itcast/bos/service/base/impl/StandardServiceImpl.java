package cn.itcast.bos.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.base.StandardRepository;
import cn.itcast.bos.domain.base.Standard;
import cn.itcast.bos.service.base.StandardService;

@Service 
@Transactional
public class StandardServiceImpl implements StandardService {

	// 注入DAO
	@Autowired
	private StandardRepository standardRepository;
	
	@Override
	@CacheEvict(value="standard",allEntries=true)//清除缓存
	//将收派标准的javabean保存到数据库
	public void save(Standard standard) {
		standardRepository.save(standard);
	}

	@Override
	//这个是用来专门做分页的，方法也是内置的，里面穿的pageable对象也是内置的
	//分页这里就不能用下面创建缓存的方式，因为pageable的值是随着分页的参数不停的变换，返回的page值就会不一样，不在是之前的那一批
	//不同的条件下，不同的缓存，如果查询的是上次相同的批次，则不会访问数据库，如果不同就在查询数据，分别查询
	@Cacheable(value="standard",key="#pageable.pageNumber+'_'+#pageable.pageSize")
	public Page<Standard> findPageData(Pageable pageable) {
		standardRepository.findAll();
		return standardRepository.findAll(pageable);
	}
	
	@Override
	@Cacheable("standard")//创建缓存
	public List<Standard> findAll() {
		return standardRepository.findAll();
	}

}
