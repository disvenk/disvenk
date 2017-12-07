package com.yepao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.ComboComment;
import com.yepao.service.ComboCommentService;

@Controller
public class ComboCommentController {
	@Autowired
	private ComboCommentService comboCommentService;
	
	@RequestMapping("/comboComment_pageQuery")
	@ResponseBody
	public List<ComboComment> getTalentComment(Long comboId){
		List<ComboComment> list = comboCommentService.getComboCommentList(comboId);
		return list;
	}
	
	@RequestMapping("/combo_comment/delete")
	public String deleteTalentComment(String ids){
		comboCommentService.deleteComboComment(ids);
		return "redirect:/pages/base/combo_comment";
	}
}
