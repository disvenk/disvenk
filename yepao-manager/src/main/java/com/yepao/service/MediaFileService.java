package com.yepao.service;

import java.util.List;

import com.yepao.pojo.Celebrationpicture;
import com.yepao.pojo.Media;
import com.yepao.pojo.Picture;

public interface MediaFileService {
	public void addPic(Picture picture);
	public void addMedia(Media media);
	public List<Picture> getImageWorks(Integer id);
	public List<Media> getMediaWorks(Integer id);
	public Picture getPic(Integer id);
	public Media getMedia(Integer id);
	public void deletePic(Integer id);
	public void deleteMedia(Integer id);
	public List<Picture> getPicByTid(Integer id);
	public List<Media> getMediaByTid(Integer id);
	
	public void addCelebrationPic(Celebrationpicture celebrationpicture);
	public Celebrationpicture getCelebrationPic(Integer id);
	public void deleteCelebrationPic(Integer id);
	public List<Celebrationpicture> getPicByCid(Long id);
}
