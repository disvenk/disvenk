package com.yepao.service;

import java.util.List;

import com.yepao.pojo.TalentComment;

public interface TanlentCommentService {
	public List<TalentComment> getTalentCommentList();
	public void deleteTalentComment(String ids);
}
