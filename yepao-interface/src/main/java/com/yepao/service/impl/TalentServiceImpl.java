package com.yepao.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.MediaMapper;
import com.yepao.mapper.PictureMapper;
import com.yepao.mapper.TalentCommentMapper;
import com.yepao.mapper.TalentReservedMapper;
import com.yepao.mapper.WeddingTalentMapper;
import com.yepao.pojo.Media;
import com.yepao.pojo.MediaExample;
import com.yepao.pojo.Picture;
import com.yepao.pojo.PictureExample;
import com.yepao.pojo.TalentComment;
import com.yepao.pojo.TalentCommentExample;
import com.yepao.pojo.TalentGroupByOccu;
import com.yepao.pojo.TalentReserved;
import com.yepao.pojo.TalentReservedExample;
import com.yepao.pojo.WeddingTalent;
import com.yepao.pojo.WeddingTalentExample;
import com.yepao.pojo.WeddingTalentExample.Criteria;
import com.yepao.service.TalentService;

@Service
public class TalentServiceImpl implements TalentService{

	@Autowired
	private WeddingTalentMapper weddingTalentMapper;
	
	@Autowired
	private PictureMapper pictureMapper;
	
	@Autowired
	private MediaMapper mediaMapper;
	
	@Autowired
	private TalentCommentMapper tCommentMapper;
	
	@Autowired
	private TalentReservedMapper tReservedMapper;
	
	
	//获取人才
	public List<WeddingTalent> getWeddingTalents(String name) {
		WeddingTalentExample example = new WeddingTalentExample();
		Criteria criteria = example.createCriteria();
		 criteria.andOccupationEqualTo(name);
		 List<WeddingTalent> list = weddingTalentMapper.selectByExample(example);
		return list;
	}

	//保存婚礼人才
	public void saveTalent(WeddingTalent eTalent) {
		weddingTalentMapper.insert(eTalent);
		
	}

	//查询单个人才
	public WeddingTalent getWeddingTalent(Long id) {
		WeddingTalent wTalent = weddingTalentMapper.selectByPrimaryKey(id);
		return wTalent;
	}

	//更改人才信息
	public void updateTalent(WeddingTalent wTalent) {
		weddingTalentMapper.updateByPrimaryKey(wTalent);
		
	}

	//删除人才
	public void deleteTalent(Long id) {
		weddingTalentMapper.deleteByPrimaryKey(id);
		
	}

	//chenXinneng below
	//获取全部人才
	public List<TalentGroupByOccu> getWeddingTalentList(Long hotelId,Date reservedDate) {
		List<TalentGroupByOccu> tgboList = weddingTalentMapper.selectTalentGroupByOccu(hotelId);
		for(TalentGroupByOccu tgbo:tgboList) {
			for(WeddingTalent t:tgbo.getTalentList()) {
				autoSetFreeStatus(t,reservedDate);
			}
		}
		
		return tgboList;
	}
	
	public Map<String,Object> getWeddingTalentDetail(Long id,Date reservedDate){
		Map<String,Object> talentDetailMap = new HashMap<String,Object>();
		WeddingTalent wTalent = weddingTalentMapper.selectByPrimaryKey(id);
		autoSetFreeStatus(wTalent, reservedDate);
		talentDetailMap.put("talent", wTalent);
		
		PictureExample picExample = new PictureExample();
		com.yepao.pojo.PictureExample.Criteria picCriteria = picExample.createCriteria();
		picCriteria.andTalentIdEqualTo(Integer.parseInt(id.toString()));
		picExample.setOrderByClause("`uptime` DESC");
		List<Picture> picList = pictureMapper.selectByExample(picExample);
		talentDetailMap.put("pictureList", picList);
		
		MediaExample mediaExample = new MediaExample();
		com.yepao.pojo.MediaExample.Criteria mediaCriteria = mediaExample.createCriteria();
		mediaCriteria.andTalentIdEqualTo(Integer.parseInt(id.toString()));
		picExample.setOrderByClause("`uptime` DESC");
		List<Media> mediaList = mediaMapper.selectByExample(mediaExample);
		talentDetailMap.put("mediaList", mediaList);
		
		TalentCommentExample tCommentExample = new TalentCommentExample();
		com.yepao.pojo.TalentCommentExample.Criteria tCommentCriteria = tCommentExample.createCriteria();
		tCommentCriteria.andTalentIdEqualTo(id);
		List<TalentComment> tCommentList = tCommentMapper.selectByExample(tCommentExample);
		talentDetailMap.put("talentCommentList", tCommentList);
		
		return talentDetailMap;
	}

	public List<WeddingTalent> getTalentListByOccupation(Long talentId,String orderByClause,Date reservedDate) {
		WeddingTalent talent = weddingTalentMapper.selectByPrimaryKey(talentId);
		Long hotelid = talent.getHotelid();
		String occupation = talent.getOccupation();
		WeddingTalentExample talentExample = new WeddingTalentExample();
		Criteria criteria = talentExample.createCriteria();
		criteria.andHotelidEqualTo(hotelid);
		criteria.andOccupationEqualTo(occupation);
		criteria.andWeddingTalentIdNotEqualTo(talentId);
		talentExample.setOrderByClause(orderByClause);
		List<WeddingTalent> list = weddingTalentMapper.selectByExample(talentExample);
		for(WeddingTalent t:list) {
			autoSetFreeStatus(t,reservedDate);
		}
		return list;
	}
	
	/**
	 * 设置人才是否有空
	 * @param talent 人才
	 * @param reservedDate 预定日期
	 */
	private void autoSetFreeStatus(WeddingTalent talent,Date reservedDate) {
		Long weddingTalentId = talent.getWeddingTalentId();
		TalentReservedExample tReservedExample = new TalentReservedExample();
		com.yepao.pojo.TalentReservedExample.Criteria tReservedCriteria = tReservedExample.createCriteria();
		tReservedCriteria.andWeddingTalentIdEqualTo(weddingTalentId);
		tReservedCriteria.andReservedDateEqualTo(reservedDate);
		List<TalentReserved> tReservedList = tReservedMapper.selectByExample(tReservedExample);
		if(tReservedList.size()>0)
			talent.setFreeStatus(false);
		else
			talent.setFreeStatus(true);
	}

}
