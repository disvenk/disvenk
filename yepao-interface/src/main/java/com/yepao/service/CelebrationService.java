package com.yepao.service;

import java.util.List;

import com.yepao.pojo.CelePicGroupByDate;
import com.yepao.pojo.Celebration;
import com.yepao.pojo.CelebrationPicture;

public interface CelebrationService {
	public List<Celebration> getCelebrationList();
	public void addCelebration(Celebration celebration);
	public Celebration getCelebration(Long id);
	public void update(Celebration celebration);
	public void delete(Long id);
	
	//根据酒店id查看庆典列表
	public List<Celebration> getCelebrationList(Long hotelId);
	public List<CelePicGroupByDate> getCelebrationPicture(Long celebrationId);
}
