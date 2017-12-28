package cn.itcast.bos.service.take_delivery.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.base.PromotionRepository;
import cn.itcast.bos.domain.take_delivery.PageBean;
import cn.itcast.bos.domain.take_delivery.Promotion;
import cn.itcast.bos.service.take_delivery.PromotionService;

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService {

	@Autowired
	private PromotionRepository promotionRepository;
	
	//保存promotion
	@Override
	public void save(Promotion promotion) {
		promotionRepository.save(promotion);
	}

	//查询所有的promotion
	@Override
	public Page<Promotion> findPageData(Pageable pageable) {
		return promotionRepository.findAll(pageable);
	}

	//用于客户端分页显示的查询所有promotion
	@Override
	public PageBean<Promotion> findPageData(int page,int rows) {
		Pageable pageable = new PageRequest(page-1,rows);
		Page<Promotion> pageData = promotionRepository.findAll(pageable);
		//将数据封装到pageBean当中返回
		PageBean<Promotion> pageBean = new PageBean<Promotion>();
		pageBean.setTotalCount(pageData.getTotalElements());
		pageBean.setPageData(pageData.getContent());
		return pageBean;
	}

	//根据id查询详情
	@Override
	public Promotion findById(Integer id) {
		return promotionRepository.findOne(id);
	}
	
	@Override
	public void updateStatus(Date date) {
		promotionRepository.updateStatus(date);
	}

	@Override
	public void show() {
		System.out.println("制定了定时任务");
		
	}

}
