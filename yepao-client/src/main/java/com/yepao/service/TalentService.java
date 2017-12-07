package com.yepao.service;

import java.util.List;

import com.yepao.pojo.WeddingTalent;

public interface TalentService {
	public List<WeddingTalent> getWeddingTalents(String name,Long hotelId);
	public void saveTalent(WeddingTalent wTalent);
	public WeddingTalent getWeddingTalent(Long id);
	public void updateTalent(WeddingTalent wTalent);
	public void deleteTalent(Long id);
}
