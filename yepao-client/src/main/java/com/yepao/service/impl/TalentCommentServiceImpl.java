package com.yepao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.TalentCommentMapper;
import com.yepao.pojo.TalentComment;
import com.yepao.pojo.TalentCommentExample;
import com.yepao.pojo.TalentCommentExample.Criteria;
import com.yepao.service.TanlentCommentService;
import com.yepao.utils.FastDFSClient;

@Service
public class TalentCommentServiceImpl implements TanlentCommentService{

	@Autowired
	private TalentCommentMapper talentCommentMapper;
	
	public List<TalentComment> getTalentCommentList(Long talentId) {
		TalentCommentExample example = new TalentCommentExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andTalentIdEqualTo(talentId);
		List<TalentComment> list = talentCommentMapper.selectByExample(example);
		return list;
	}

	public void deleteTalentComment(String ids) {
		String[] Tids = ids.split(",");
		try {
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
			for (String string : Tids) {
				Long id = Long.parseLong(string);
				TalentComment talentComment = talentCommentMapper.selectByPrimaryKey(id);
				
				String img = talentComment.getImg();
				if(img!=null){
				String[] imgs = img.split(",");
				for (String string2 : imgs) {
					fastDFSClient.delete_file(string2.substring(20));
				}
				}
				talentCommentMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
