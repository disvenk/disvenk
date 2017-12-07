package com.yepao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.HallComment;
import com.yepao.service.HallCommentService;

@Controller
public class HallCommentController {
	@Autowired
	private HallCommentService hallCommentService;
	
	@RequestMapping("/hallComment_pageQuery")
	@ResponseBody
	public List<HallComment> getHallComment(Long hallId){
		List<HallComment> list = hallCommentService.getHallCommentList(hallId);
		return list;
	}
	
	@RequestMapping("/hallComment_comment/delete")
	public String deleteTalentComment(String ids){
		hallCommentService.deleteHallComment(ids);
		return "redirect:/pages/base/hall_comment";
	}
}
