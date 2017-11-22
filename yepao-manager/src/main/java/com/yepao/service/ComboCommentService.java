package com.yepao.service;

import java.util.List;

import com.yepao.pojo.ComboComment;

public interface ComboCommentService {
	public List<ComboComment> getComboCommentList();
	public void deleteComboComment(String ids);
}
