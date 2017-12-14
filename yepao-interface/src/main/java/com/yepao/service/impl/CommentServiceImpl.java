package com.yepao.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.CelebrationCommentMapper;
import com.yepao.mapper.ComboCommentMapper;
import com.yepao.mapper.HallCommentMapper;
import com.yepao.mapper.HotelMapper;
import com.yepao.mapper.OrdersMapper;
import com.yepao.mapper.SyntheCommentMapper;
import com.yepao.mapper.TalentCommentMapper;
import com.yepao.mapper.WeddingTalentMapper;
import com.yepao.pojo.CelebrationComment;
import com.yepao.pojo.CelebrationCommentExample;
import com.yepao.pojo.ComboComment;
import com.yepao.pojo.ComboCommentExample;
import com.yepao.pojo.HallComment;
import com.yepao.pojo.HallCommentExample;
import com.yepao.pojo.Hotel;
import com.yepao.pojo.HotelExample;
import com.yepao.pojo.HotelExample.Criteria;
import com.yepao.pojo.Orders;
import com.yepao.pojo.SyntheComment;
import com.yepao.pojo.TalentComment;
import com.yepao.pojo.TalentCommentExample;
import com.yepao.pojo.WeddingTalent;
import com.yepao.service.CommentService;
import com.yepao.utils.CommonConstants;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private HallCommentMapper hallComMapper;
	@Autowired
	private TalentCommentMapper talentComMapper;
	@Autowired
	private ComboCommentMapper comboComMapper;
	@Autowired
	private CelebrationCommentMapper celeComMapper;
	@Autowired
	private SyntheCommentMapper syntheComMapper;
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private HotelMapper hotelMapper;
	@Autowired
	private WeddingTalentMapper weddingTalentMapper;
	
	public List<HallComment> getHallComment(Long hallId) {
		HallCommentExample hallComExample = new HallCommentExample();
		com.yepao.pojo.HallCommentExample.Criteria hallComCriteria = hallComExample.createCriteria();
		hallComCriteria.andHallIdEqualTo(hallId);
		hallComExample.setOrderByClause("`created` DESC");
		List<HallComment> hallComList = hallComMapper.selectByExample(hallComExample);
		return hallComList;
	}

	public List<ComboComment> getComboComment(Long comboId) {
		ComboCommentExample comboComExample = new ComboCommentExample();
		com.yepao.pojo.ComboCommentExample.Criteria comboComCriteria = comboComExample.createCriteria();
		comboComCriteria.andComboIdEqualTo(comboId);
		comboComExample.setOrderByClause("`created` DESC");
		List<ComboComment> comboComList = comboComMapper.selectByExample(comboComExample);
		return comboComList;
	}

	public List<CelebrationComment> getCelebrationComment(Long celebrationId) {
		CelebrationCommentExample celeComExample = new CelebrationCommentExample();
		com.yepao.pojo.CelebrationCommentExample.Criteria celeComCriteria = celeComExample.createCriteria();
		celeComCriteria.andCelebrationIdEqualTo(celebrationId);
		celeComExample.setOrderByClause("`created` DESC");
		List<CelebrationComment> celeComList = celeComMapper.selectByExample(celeComExample);
		return celeComList;
	}

	public List<TalentComment> getTalentComment(Long talentId) {
		TalentCommentExample talentComExample = new TalentCommentExample();
		com.yepao.pojo.TalentCommentExample.Criteria talentComCriteria = talentComExample.createCriteria();
		talentComCriteria.andTalentIdEqualTo(talentId);
		talentComExample.setOrderByClause("`created` DESC");
		List<TalentComment> talentComList = talentComMapper.selectByExample(talentComExample);
		return talentComList;
	}

	public boolean submitComment(HallComment hallCom, ComboComment comboCom, CelebrationComment celeCom,
			SyntheComment syntheCom, List<TalentComment> talentComList, Long orderId) {
		if(hallCom!=null)
			hallComMapper.insert(hallCom);
		if(comboCom!=null)
			comboComMapper.insert(comboCom);
		if(celeCom!=null)
			celeComMapper.insert(celeCom);
		if(syntheCom!=null)
			syntheComMapper.insert(syntheCom);
		Orders order = ordersMapper.selectByPrimaryKey(orderId);
		Long hotelId = order.getHotelId();
		//更新酒店总评分
		BigDecimal avgCount = syntheComMapper.getAvgComment();
		updateHotelReputation(hotelId, avgCount);
		if(!talentComList.isEmpty()) {
			for(TalentComment t:talentComList) {
				talentComMapper.insert(t);
				updateTalentReputation(t); 			
			}
		}
		if(order != null) {
			order.setStatus(CommonConstants.COMMENTED);
			ordersMapper.updateByPrimaryKey(order);
		}
		return false;
	}
	
	/**
	 * 更新酒店评分与好评率
	 * @param hotelId 酒店id
	 * @param avgCount 本次评价分数
	 */
	private void updateHotelReputation(Long hotelId,BigDecimal avgCount) {
		HotelExample example = new HotelExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andHotelIdEqualTo(hotelId);
		List<Hotel> list = hotelMapper.selectByExample(example);
		Hotel hotel = list.get(0);
		Integer count = hotel.getCommentCount();
		BigDecimal level = hotel.getReputationLevel();
		BigDecimal newLevel = (
								(
									level.multiply(new BigDecimal(count.toString()))
										.add(avgCount)
														).divide(
																new BigDecimal(count.toString()).add(new BigDecimal("1")),2, RoundingMode.HALF_UP
																
																));//.setScale(1, BigDecimal.ROUND_HALF_UP);
		Integer goodReputation = hotel.getGoodReputation();
		if(avgCount.compareTo(new BigDecimal(4.0))>0)
			goodReputation = Math.round((Math.round(count*goodReputation/100)+1)/(count+1)*100);
		else
			goodReputation = Math.round((Math.round(count*goodReputation/100))/(count+1)*100);
		hotel.setGoodReputation(goodReputation);
		hotel.setReputationLevel(newLevel);
		hotel.setCommentCount(++count);
		hotelMapper.updateByPrimaryKey(hotel);
	}
	/**
	 * 更新人才评分与好评率
	 * @param t 本次人才评价
	 */
	private void updateTalentReputation(TalentComment t) {
		Integer score = t.getCompLevel();
		WeddingTalent talent = weddingTalentMapper.selectByPrimaryKey(t.getTalentId());
		Integer count = talent.getCommentCount();
		BigDecimal level = talent.getComprehensive();
		Integer goodReputation = talent.getGoodReputation();
		if(score>=4)
			goodReputation = Math.round((Math.round(count*goodReputation/100)+1)/(count+1)*100);
		else
			goodReputation = Math.round((Math.round(count*goodReputation/100))/(count+1)*100);
		BigDecimal newLevel = ((level.multiply(new BigDecimal(count.toString())).add(new BigDecimal(score.toString()))).divide(new BigDecimal(count.toString()).add(new BigDecimal("1")),2,RoundingMode.HALF_UP));
		
		talent.setGoodReputation(goodReputation);
		talent.setComprehensive(newLevel);
		talent.setCommentCount(++count);
		weddingTalentMapper.updateByPrimaryKey(talent);
	}
	
}
