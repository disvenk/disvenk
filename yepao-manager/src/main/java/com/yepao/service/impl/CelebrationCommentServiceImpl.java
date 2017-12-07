package com.yepao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.CelebrationCommentMapper;
import com.yepao.mapper.ComboCommentMapper;
import com.yepao.pojo.CelebrationComment;
import com.yepao.pojo.CelebrationCommentExample;
import com.yepao.pojo.CelebrationCommentExample.Criteria;
import com.yepao.pojo.ComboComment;
import com.yepao.pojo.ComboCommentExample;
import com.yepao.pojo.TalentComment;
import com.yepao.service.CelebrationCommentService;
import com.yepao.service.ComboCommentService;
import com.yepao.utils.FastDFSClient;

@Service
public class CelebrationCommentServiceImpl implements CelebrationCommentService {

	@Autowired
	private CelebrationCommentMapper celebrationCommentMapper;
	
	public List<CelebrationComment> getCelebrationCommentList(Long celebrationId) {
		CelebrationCommentExample example = new CelebrationCommentExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andCelebrationIdEqualTo(celebrationId);
		List<CelebrationComment> list = celebrationCommentMapper.selectByExample(example);
		return list;
	}

	public void deleteCelebration(String ids) {
		String[] Tids = ids.split(",");
		try {
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
			for (String string : Tids) {
				Long id = Long.parseLong(string);
				CelebrationComment celebrationComment = celebrationCommentMapper.selectByPrimaryKey(id);
				String[] imgs = celebrationComment.getImg().split(",");
				for (String string2 : imgs) {
					fastDFSClient.delete_file(string2.substring(20));
				}
				celebrationCommentMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	

}
