package com.yepao.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.CelebrationMapper;
import com.yepao.mapper.CelebrationpictureMapper;
import com.yepao.mapper.MediaMapper;
import com.yepao.mapper.PictureMapper;
import com.yepao.pojo.Celebrationpicture;
import com.yepao.pojo.CelebrationpictureExample;
import com.yepao.pojo.Media;
import com.yepao.pojo.MediaExample;
import com.yepao.pojo.Picture;
import com.yepao.pojo.PictureExample;
import com.yepao.pojo.PictureExample.Criteria;
import com.yepao.service.MediaFileService;

@Service
public class MediaFileseviceImpl implements MediaFileService{

	@Autowired
	private PictureMapper pictureMapper;
	@Autowired
	private MediaMapper mediaMapper;
	@Autowired
	private	CelebrationpictureMapper celebrationpictureMapper;
	
	public void addPic(Picture picture) {
		pictureMapper.insert(picture);
		
	}

	public void addMedia(Media media) {
		mediaMapper.insert(media);
		
	}

	//查询图片作品
	public List<Picture> getImageWorks(Integer id) {
		PictureExample example = new PictureExample();
		Criteria criteria = example.createCriteria();
		criteria.andTalentIdEqualTo(id);
		List<Picture> list = pictureMapper.selectByExample(example);
		return list;
	}
	
	//查询视频作品
	public List<Media> getMediaWorks(Integer id) {
		MediaExample example = new MediaExample();
		com.yepao.pojo.MediaExample.Criteria criteria = example.createCriteria();
		criteria.andTalentIdEqualTo(id);
		List<Media> list = mediaMapper.selectByExample(example);
		return list;
	}

	public Picture getPic(Integer id) {
	Picture picture = pictureMapper.selectByPrimaryKey(id);
		return picture;
	}

	public Media getMedia(Integer id) {
	Media media = mediaMapper.selectByPrimaryKey(id);
		return media;
	}

	public void deletePic(Integer id) {
		pictureMapper.deleteByPrimaryKey(id);
		
	}

	public void deleteMedia(Integer id) {
		mediaMapper.deleteByPrimaryKey(id);
		
	}

	public List<Picture> getPicByTid(Integer id) {
		PictureExample example = new PictureExample();
		Criteria criteria = example.createCriteria();
		criteria.andTalentIdEqualTo(id);
		List<Picture> list = pictureMapper.selectByExample(example);
		return list;
	}

	public List<Media> getMediaByTid(Integer id) {
		MediaExample example = new MediaExample();
		com.yepao.pojo.MediaExample.Criteria criteria = example.createCriteria();
		criteria.andTalentIdEqualTo(id);
		List<Media> list = mediaMapper.selectByExample(example);
		return list;
	}

	
	
	/*---------------------------------------------*/
	public void addCelebrationPic(Celebrationpicture celebrationpicture) {
		celebrationpictureMapper.insert(celebrationpicture);
		
	}

	public Celebrationpicture getCelebrationPic(Integer id) {
		return celebrationpictureMapper.selectByPrimaryKey(id);
		
	}

	public void deleteCelebrationPic(Integer id) {
		celebrationpictureMapper.deleteByPrimaryKey(id);
		
	}

	public List<Celebrationpicture> getPicByCid(Long id) {
		CelebrationpictureExample example = new CelebrationpictureExample();
		com.yepao.pojo.CelebrationpictureExample.Criteria criteria = example.createCriteria();
		criteria.andCelebrationIdEqualTo(id);
		List<Celebrationpicture> list = celebrationpictureMapper.selectByExample(example);
		return list;
	}

}
