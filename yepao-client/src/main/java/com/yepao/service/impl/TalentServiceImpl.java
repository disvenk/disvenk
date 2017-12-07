package com.yepao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.WeddingTalentMapper;
import com.yepao.pojo.WeddingTalent;
import com.yepao.pojo.WeddingTalentExample;
import com.yepao.pojo.WeddingTalentExample.Criteria;
import com.yepao.service.TalentService;

@Service
public class TalentServiceImpl implements TalentService{

	@Autowired
	private WeddingTalentMapper weddingTalentMapper;
	
	//获取人才
	public List<WeddingTalent> getWeddingTalents(String name,Long hotelId) {
		WeddingTalentExample example = new WeddingTalentExample();
		Criteria criteria = example.createCriteria();
		 criteria.andOccupationEqualTo(name);
		 criteria.andHotelidEqualTo(hotelId);
		 List<WeddingTalent> list = weddingTalentMapper.selectByExample(example);
		return list;
	}

	//保存婚礼人才
	public void saveTalent(WeddingTalent eTalent) {
		weddingTalentMapper.insert(eTalent);
		
	}

	//查询单个人才
	public WeddingTalent getWeddingTalent(Long id) {
		WeddingTalent wTalent = weddingTalentMapper.selectByPrimaryKey(id);
		return wTalent;
	}

	//更改人才信息
	public void updateTalent(WeddingTalent wTalent) {
		weddingTalentMapper.updateByPrimaryKey(wTalent);
		
	}

	//删除人才
	public void deleteTalent(Long id) {
		weddingTalentMapper.deleteByPrimaryKey(id);
		
	}

}
