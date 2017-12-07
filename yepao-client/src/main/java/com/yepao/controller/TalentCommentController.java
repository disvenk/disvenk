package com.yepao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.TalentComment;
import com.yepao.service.TanlentCommentService;

@Controller
public class TalentCommentController {

	@Autowired
	private TanlentCommentService tanlentCommentService;
	
	@RequestMapping("/talentComment_pageQuery")
	@ResponseBody
	public List<TalentComment> getTalentComment(Long talentId){
		List<TalentComment> list = tanlentCommentService.getTalentCommentList(talentId);
		return list;
	}
	
	@RequestMapping("/talent_comment/delete")
	public String deleteTalentComment(String talent,String ids){
		tanlentCommentService.deleteTalentComment(ids);
		return "redirect:/pages/base/"+talent+"_comment";
	}
}
