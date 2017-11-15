package com.yepao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.CelebrationMapper;
import com.yepao.pojo.Celebration;
import com.yepao.pojo.CelebrationExample;
import com.yepao.service.CelebrationService;

@Service
public class CelebrationServiceImpl implements CelebrationService {

	@Autowired
	private CelebrationMapper celebrationMapper;
	
	//查询宴会庆典
	public List<Celebration> getCelebrationList() {
		CelebrationExample example = new CelebrationExample();
		List<Celebration> list = celebrationMapper.selectByExample(example);
		return list;
	}

	//增加宴会庆典
	public void addCelebration(Celebration celebration) {
		celebrationMapper.insert(celebration);
	}

	//查询单个
	public Celebration getCelebration(Long id) {
		Celebration celebration = celebrationMapper.selectByPrimaryKey(id);
		return celebration;
	}

	//修改
	public void update(Celebration celebration) {
		celebrationMapper.updateByPrimaryKey(celebration);
		
	}
	
	//删除庆典
	public void delete(Long id) {
		celebrationMapper.deleteByPrimaryKey(id);
		
	}

	

	

}
