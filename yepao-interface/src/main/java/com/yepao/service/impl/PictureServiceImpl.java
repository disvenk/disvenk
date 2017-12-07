package com.yepao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.PictureMapper;
import com.yepao.pojo.PicGroupByDate;
import com.yepao.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService {

	@Autowired
	private PictureMapper pictureMapper;
	
	public List<PicGroupByDate> getTalentPicturesByTalentId(Integer talentId) {
		List<PicGroupByDate> picGroupByDateList = pictureMapper.getTalentPicturesByTalentId(talentId);
		return picGroupByDateList;
	}

}
