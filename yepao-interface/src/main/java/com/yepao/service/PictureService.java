package com.yepao.service;

import java.util.List;

import com.yepao.pojo.PicGroupByDate;
import com.yepao.pojo.Picture;

public interface PictureService {

	public List<PicGroupByDate> getTalentPicturesByTalentId(Integer talentId);
}
