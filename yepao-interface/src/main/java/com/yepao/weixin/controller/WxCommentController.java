package com.yepao.weixin.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.CelebrationComment;
import com.yepao.pojo.ComboComment;
import com.yepao.pojo.HallComment;
import com.yepao.pojo.SyntheComment;
import com.yepao.pojo.TalentComment;
import com.yepao.service.CommentService;
import com.yepao.utils.CommonConstants;
import com.yepao.utils.JsonUtils;

@Controller
@RequestMapping("/comment")
public class WxCommentController {
	
	@Autowired
	private CommentService commentService;
	
	/**
	 * 查看宴会厅评价
	 * @param hallId 宴会厅id
	 * @return
	 */
	@RequestMapping("/getHallCom")
	@ResponseBody
	public List<HallComment> getHallComment(Long hallId) {
		List<HallComment> hallCommentList = commentService.getHallComment(hallId);
		return hallCommentList;
	}
	/**
	 * 查看菜单评价
	 * @param comboId 菜单id
	 * @return
	 */
	@RequestMapping("/getComboCom")
	@ResponseBody
	public List<ComboComment> getComboComment(Long comboId) {
		List<ComboComment> comboCommentList = commentService.getComboComment(comboId);
		return comboCommentList;
	}
	/**
	 * 查看庆典评价
	 * @param hallId 庆典id
	 * @return
	 */
	@RequestMapping("/getCeleCom")
	@ResponseBody
	public List<CelebrationComment> getCelebrationComment(Long celebrationId) {
		List<CelebrationComment> celeCommentList = commentService.getCelebrationComment(celebrationId);
		return celeCommentList;
	}
	/**
	 * 查看人才评价
	 * @param hallId 人才id
	 * @return
	 */
	@RequestMapping("/getTalentCom")
	@ResponseBody
	public List<TalentComment> getTalentComment(Long talentId) {
		List<TalentComment> talentCommentList = commentService.getTalentComment(talentId);
		return talentCommentList;
	}
	
	/**
	 * 提交评论
	 * @return 操作反馈信息
	 */
	@RequestMapping("/submitComment")
	@ResponseBody
	public String commentSubmit(HttpServletRequest request,List<TalentComment> talentComList){
		String orderIdString = request.getParameter("orderId");
		Long orderId = Long.valueOf(orderIdString);
		String customerIdString = request.getParameter("openId");
		Long customerId = Long.valueOf(customerIdString);
		String nickName = request.getParameter("nickName");
		
		String hallComString = request.getParameter("hallComment");
		String comboComString = request.getParameter("comboComment");
		String celeComString = request.getParameter("celebrationComment");
		String syntheComString = request.getParameter("syntheComment");
		//String talentComString = request.getParameter("talentComment");
		
		HallComment hallCom = JsonUtils.jsonToPojo(hallComString, HallComment.class);
		ComboComment comboCom = JsonUtils.jsonToPojo(comboComString, ComboComment.class);
		CelebrationComment celeCom = JsonUtils.jsonToPojo(celeComString, CelebrationComment.class);
		SyntheComment syntheCom = JsonUtils.jsonToPojo(syntheComString, SyntheComment.class);//综合评价
		
		hallCom.setCustomerId(customerId);
		hallCom.setNickName(nickName);
		hallCom.setCreated(new Date());
		
		comboCom.setCustomerId(customerId);
		comboCom.setNickName(nickName);
		comboCom.setCreated(new Date());
		
		celeCom.setCustomerId(customerId);
		celeCom.setNickName(nickName);
		celeCom.setCreated(new Date());
		
		syntheCom.setCustomerId(customerId);
		syntheCom.setNickName(nickName);
		syntheCom.setCreatedDate(new Date());
		
		for(TalentComment t:talentComList) {
			t.setCustomerId(customerId);
			t.setNickName(nickName);
			t.setCreated(new Date());
		}
		
		boolean result = commentService.submitComment(hallCom,comboCom,celeCom,syntheCom,talentComList,orderId);
		if(result)
			return CommonConstants.SUCCESS;
		else
			return CommonConstants.ERROR;
	}
	
	

}
