package com.yepao.service;

import java.util.List;

import com.yepao.pojo.HallComment;

public interface HallCommentService {
	public List<HallComment> getHallCommentList();
	public void deleteHallComment(String ids);
}
