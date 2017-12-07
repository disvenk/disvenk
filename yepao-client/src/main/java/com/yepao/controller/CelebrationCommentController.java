package com.yepao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.CelebrationComment;
import com.yepao.service.CelebrationCommentService;

@Controller
public class CelebrationCommentController {
	@Autowired
	private CelebrationCommentService celebrationCommentService;
	
	@RequestMapping("/celebrationComment_pageQuery")
	@ResponseBody
	public List<CelebrationComment> getTalentComment(Long celebrationId){
		List<CelebrationComment> list = celebrationCommentService.getCelebrationCommentList(celebrationId);
		return list;
	}
	
	@RequestMapping("/celebration_comment/delete")
	public String deleteTalentComment(String ids){
		celebrationCommentService.deleteCelebration(ids);
		return "redirect:/pages/base/celebration_comment";
	}
}
