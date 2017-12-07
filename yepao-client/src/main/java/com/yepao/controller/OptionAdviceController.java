package com.yepao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.CelebrationComment;
import com.yepao.pojo.OptionAdvice;
import com.yepao.service.CelebrationCommentService;
import com.yepao.service.OptionAdviceService;

@Controller
public class OptionAdviceController {
	
	@Autowired
	private OptionAdviceService optionAdviceService;
	
	@RequestMapping("/optionAdvice_pageQuery")
	@ResponseBody
	public List<OptionAdvice> getOptionAdvice(Long hotelId){
		List<OptionAdvice> list = optionAdviceService.getOptionAdviceList(hotelId);
		return list;
	}
	
	@RequestMapping("/option_advice/delete")
	public String deleteTalentComment(String ids){
		optionAdviceService.deleteOptionAdvice(ids);
		return "redirect:/pages/base/option_advice";
	}
}
