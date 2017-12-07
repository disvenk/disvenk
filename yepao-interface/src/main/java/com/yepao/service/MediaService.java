package com.yepao.service;

import java.util.List;

import com.yepao.pojo.MedGroupByDate;

public interface MediaService {
	public List<MedGroupByDate> getTalentMediasByTalentId(Integer talentId);
}
