package com.yepao.service;

import java.util.List;

import com.yepao.pojo.CelebrationComment;

public interface CelebrationCommentService {
	public List<CelebrationComment> getCelebrationCommentList();
	public void deleteCelebration(String ids);
}
