package com.yepao.service;

import java.util.List;

import com.yepao.pojo.BanquetHall;
import com.yepao.utils.YePaoResult;

public interface HallService {
	public YePaoResult addHall(BanquetHall banquetHall);
	public List<BanquetHall> getHallList();
	public BanquetHall getBanquetHall(Long id);
	public void deleteHall(Long id);
	//查询单个酒店的宴会厅
	public List<BanquetHall> getHallList(Long hotelId);
}