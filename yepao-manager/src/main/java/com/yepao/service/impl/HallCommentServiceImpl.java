package com.yepao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.HallCommentMapper;
import com.yepao.pojo.HallComment;
import com.yepao.pojo.HallCommentExample;
import com.yepao.pojo.HallCommentExample.Criteria;
import com.yepao.service.HallCommentService;
import com.yepao.utils.FastDFSClient;

@Service
public class HallCommentServiceImpl implements HallCommentService{
	@Autowired
	private HallCommentMapper hallCommentMapper;
	
	public List<HallComment> getHallCommentList(Long hallId) {
		HallCommentExample example = new HallCommentExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andHallIdEqualTo(hallId);
		List<HallComment> list = hallCommentMapper.selectByExample(example);
		return list;
	}

	public void deleteHallComment(String ids) {
		String[] Tids = ids.split(",");
		try {
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
			for (String string : Tids) {
				Long id = Long.parseLong(string);
				HallComment hallComment = hallCommentMapper.selectByPrimaryKey(id);
				
				String img = hallComment.getImg();
				if(img!=null){
					String[] imgs = img.split(",");
				
					for (String string2 : imgs) {
						if(string2!=null)
						fastDFSClient.delete_file(string2.substring(20));
					}
					}
				hallCommentMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
