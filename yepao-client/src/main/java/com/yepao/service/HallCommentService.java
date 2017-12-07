package com.yepao.service;

import java.util.List;

import com.yepao.pojo.HallComment;

public interface HallCommentService {
	public List<HallComment> getHallCommentList(Long hallId);
	public void deleteHallComment(String ids);
}
