package cn.itcast.bos.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.base.TakeTimeRepository;
import cn.itcast.bos.domain.base.TakeTime;
import cn.itcast.bos.service.base.TakeTimeService;

@Service
@Transactional
public class TakeTimeServiceImpl implements TakeTimeService {

	@Autowired
	private TakeTimeRepository takeTimeRepository;

	//保存单个的收派时间
	@Override
	public void saveTakeTime(TakeTime takeTime) {
		takeTimeRepository.save(takeTime);
	}
	
	//查询所有的收派时间
	@Override
	public List<TakeTime> findAll() {
		return takeTimeRepository.findAll();
	}

	

}
