package com.yepao.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.CelebrationPictureMapper;
import com.yepao.mapper.MediaMapper;
import com.yepao.mapper.PictureMapper;
import com.yepao.pojo.CelebrationPicture;
import com.yepao.pojo.CelebrationPictureExample;
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
	private	CelebrationPictureMapper celebrationPictureMapper;
	
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
	public void addCelebrationPic(CelebrationPicture celebrationPicture) {
		celebrationPictureMapper.insert(celebrationPicture);
		
	}

	public CelebrationPicture getCelebrationPic(Long id) {
		return celebrationPictureMapper.selectByPrimaryKey(id);
		
	}

	public void deleteCelebrationPic(Long id) {
		celebrationPictureMapper.deleteByPrimaryKey(id);
		
	}

	public List<CelebrationPicture> getPicByCid(Long id) {
		CelebrationPictureExample example = new CelebrationPictureExample();
		com.yepao.pojo.CelebrationPictureExample.Criteria criteria = example.createCriteria();
		criteria.andCelebrationIdEqualTo(id);
		List<CelebrationPicture> list = celebrationPictureMapper.selectByExample(example);
		return list;
	}

}
