package com.yepao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.BanquetHallMapper;
import com.yepao.pojo.BanquetHall;
import com.yepao.pojo.BanquetHallExample;
import com.yepao.pojo.BanquetHallExample.Criteria;
import com.yepao.service.HallService;
import com.yepao.utils.YePaoResult;

@Service
public class HallServiceImpl implements HallService{
	
	@Autowired
	private BanquetHallMapper bHallMapper;

	//添加宴会大厅
	public YePaoResult addHall(BanquetHall banquetHall) {
		banquetHall.setCreated(new Date());
		banquetHall.setUpdated(new Date());
		bHallMapper.insert(banquetHall);
		return YePaoResult.ok();
	}

	//查询宴会大厅
	public List<BanquetHall> getHallList(Long hotelId) {
		BanquetHallExample example = new BanquetHallExample();
		Criteria criteria = example.createCriteria();
		criteria.andHotelidEqualTo(hotelId);
		List<BanquetHall> list = bHallMapper.selectByExample(example);
		return list;
	}

	//查询单个宴会大厅
	public BanquetHall getBanquetHall(Long id) {
		return	bHallMapper.selectByPrimaryKey(id);
		
	}

	//删除宴会大厅
	public void deleteHall(Long id) {
		bHallMapper.deleteByPrimaryKey(id);
		
	}
	
	
}
