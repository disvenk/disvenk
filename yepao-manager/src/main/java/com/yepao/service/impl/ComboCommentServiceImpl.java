package com.yepao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.ComboCommentMapper;
import com.yepao.pojo.ComboComment;
import com.yepao.pojo.ComboCommentExample;
import com.yepao.pojo.ComboCommentExample.Criteria;
import com.yepao.pojo.TalentComment;
import com.yepao.service.ComboCommentService;
import com.yepao.utils.FastDFSClient;

@Service
public class ComboCommentServiceImpl implements ComboCommentService {

	@Autowired
	private ComboCommentMapper comboCommentMapper;
	
	public List<ComboComment> getComboCommentList(Long comboId) {
		ComboCommentExample example = new ComboCommentExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andComboIdEqualTo(comboId);
		List<ComboComment> list = comboCommentMapper.selectByExample(example);
		return list;
	}

	public void deleteComboComment(String ids) {
		String[] Tids = ids.split(",");
		try {
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
			for (String string : Tids) {
				Long id = Long.parseLong(string);
				ComboComment comboComment = comboCommentMapper.selectByPrimaryKey(id);
				String[] imgs = comboComment.getImg().split(",");
				for (String string2 : imgs) {
					fastDFSClient.delete_file(string2.substring(20));
				}
				comboCommentMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	

}
