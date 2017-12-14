package com.yepao.weixin.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.other.pojo.TalentComment1;
import com.sun.org.apache.bcel.internal.generic.RETURN;
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
	public String commentSubmit(Long orderId,String headImg,String openId,String nickName,String hallComment,String comboComment,
								String celebrationComment,BigDecimal syntheCommentLevel,String talentComment){
		
		HallComment hallCom = new HallComment();
		ComboComment comboCom = new ComboComment();
		CelebrationComment celeCombo = new CelebrationComment();
		TalentComment1 talentCombo = new TalentComment1();
		if(hallComment != null) {
			LinkedHashMap<String, Object> hallJson = (LinkedHashMap<String, Object>) JsonUtils.jsonToPojo(hallComment, Object.class);
			String commentContent = (String) hallJson.get("commentContent");
			Integer compLevel = Integer.parseInt(hallJson.get("compLevel").toString());
			Long hallId = Long.parseLong(hallJson.get("hallId").toString());
			hallCom.setHallId(hallId);
			hallCom.setHeadimg(headImg);
			hallCom.setCompLevel(compLevel);
			hallCom.setCommentContent(commentContent);
			hallCom.setCustomerId(openId);
			hallCom.setNickName(nickName);
			hallCom.setCreated(new Date());
		}
		if(comboComment != null) {
			LinkedHashMap<String, Object> comboJson = (LinkedHashMap<String, Object>) JsonUtils.jsonToPojo(comboComment, Object.class);
			String commentContent = (String) comboJson.get("commentContent");
			Integer compLevel = Integer.parseInt(comboJson.get("compLevel").toString());
			Long comboId = Long.parseLong(comboJson.get("comboId").toString());
			comboCom.setComboId(comboId);
			comboCom.setHeadimg(headImg);
			comboCom.setCommentContent(commentContent);
			comboCom.setCompLevel(compLevel);
			comboCom.setCustomerId(openId);
			comboCom.setNickName(nickName);
			comboCom.setCreated(new Date());
		}
		if(celebrationComment != null) {
			LinkedHashMap<String, Object> celeJson = (LinkedHashMap<String, Object>) JsonUtils.jsonToPojo(celebrationComment, Object.class);
			String commentContent = (String) celeJson.get("commentContent");
			Integer compLevel = Integer.parseInt(celeJson.get("compLevel").toString());
			Long celebrationId = Long.parseLong(celeJson.get("celebrationId").toString());
			celeCombo.setCelebrationId(celebrationId);
			celeCombo.setHeadimg(headImg);
			celeCombo.setCommentContent(commentContent);
			celeCombo.setCompLevel(compLevel);
			celeCombo.setCustomerId(openId);
			celeCombo.setNickName(nickName);
			celeCombo.setCreated(new Date());
		}
		
		SyntheComment syntheCom = new SyntheComment();
		syntheCom.setCustomerId(openId);
		syntheCom.setNickName(nickName);
		syntheCom.setCreatedDate(new Date());
		syntheCom.setCompLevel(syntheCommentLevel);
		
		List<TalentComment> talentComList = new ArrayList<TalentComment>();
		if(talentComment != null) {
			LinkedHashMap<String, Object> talentJson = (LinkedHashMap<String, Object>) JsonUtils.jsonToPojo(talentComment, Object.class);
			String talentIdString = (String) talentJson.get("talentId");
			String commentContentString = (String) talentJson.get("commentContent");
			String compLevelString = (String) talentJson.get("compLevel");
			//String imgString = (String)talentCommentObj.get("img");
			
			String[] talentIdStrings = talentIdString.split(",");
			String[] compLevelStrings = compLevelString.split(",");
			//String[] imgStrings = imgString.split(",");
			
			for(int i=0;i<talentIdStrings.length;i++) {
				TalentComment t = new TalentComment();
				t.setCustomerId(openId);
				t.setHeadimg(headImg);
				t.setNickName(nickName);
				t.setCreated(new Date());
				t.setTalentId(Long.valueOf(talentIdStrings[i]));
				t.setCompLevel(Integer.valueOf(compLevelStrings[i]));
				//t.setImg(imgStrings[i]);
				t.setCommentContent(commentContentString);
				talentComList.add(t);
			}
		}
		
		boolean result = commentService.submitComment(hallCom,comboCom,celeCombo,syntheCom,talentComList,orderId);
		if(result)
			return CommonConstants.SUCCESS;
		else
			return CommonConstants.ERROR;
	}
	
	
}
