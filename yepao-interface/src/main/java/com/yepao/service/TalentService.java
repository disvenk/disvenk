package com.yepao.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.yepao.pojo.TalentGroupByOccu;
import com.yepao.pojo.WeddingTalent;

public interface TalentService {
	public List<WeddingTalent> getWeddingTalents(String name);
	public void saveTalent(WeddingTalent wTalent);
	public WeddingTalent getWeddingTalent(Long id);
	public void updateTalent(WeddingTalent wTalent);
	public void deleteTalent(Long id);
	
	//chen Xinneng below
	public List<TalentGroupByOccu> getWeddingTalentList(Long hotelId,Date reservedDate);
	public Map<String,Object> getWeddingTalentDetail(Long id,Date reservedDate);
	public List<WeddingTalent> getTalentListByOccupation(Long talentId,String orderByClause,Date reservedDate);
}
