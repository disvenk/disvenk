package com.yepao.service;

import java.util.List;

import com.yepao.pojo.Celebration;

public interface CelebrationService {
	public List<Celebration> getCelebrationList(Long hotelId);
	public void addCelebration(Celebration celebration);
	public Celebration getCelebration(Long id);
	public void update(Celebration celebration);
	public void delete(Long id);
}
