package com.yepao.service;

import java.util.List;

import com.yepao.pojo.BanquetHall;
import com.yepao.utils.YePaoResult;

public interface HallService {
	public YePaoResult addHall(BanquetHall banquetHall);
	public List<BanquetHall> getHallList();
}
