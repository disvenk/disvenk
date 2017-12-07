package com.yepao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.MediaMapper;
import com.yepao.pojo.MedGroupByDate;
import com.yepao.service.MediaService;

@Service
public class MediaServiceImpl implements MediaService {

	@Autowired
	private MediaMapper mediaMapper;
	
	public List<MedGroupByDate> getTalentMediasByTalentId(Integer talentId) {
		List<MedGroupByDate> medGroupByDateList = mediaMapper.getTalentMediasByTalentId(talentId);
		return medGroupByDateList;
	}

}
