package com.yepao.service;

import java.util.List;

import com.yepao.pojo.CelebrationComment;
import com.yepao.pojo.ComboComment;
import com.yepao.pojo.HallComment;
import com.yepao.pojo.SyntheComment;
import com.yepao.pojo.TalentComment;

public interface CommentService {
	public List<HallComment> getHallComment(Long hallId);
	public List<ComboComment> getComboComment(Long comboId);
	public List<CelebrationComment> getCelebrationComment(Long celebrationId);
	public List<TalentComment> getTalentComment(Long talentId);
	public boolean submitComment(HallComment hallCom,ComboComment comboCom,CelebrationComment celeCom,SyntheComment syntheCom,List<TalentComment> talentComList,Long orderId);
}
