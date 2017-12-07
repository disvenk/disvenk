package com.yepao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yepao.pojo.MedGroupByDate;
import com.yepao.pojo.Media;
import com.yepao.pojo.MediaExample;

public interface MediaMapper {
    int countByExample(MediaExample example);

    int deleteByExample(MediaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Media record);

    int insertSelective(Media record);

    List<Media> selectByExample(MediaExample example);

    Media selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Media record, @Param("example") MediaExample example);

    int updateByExample(@Param("record") Media record, @Param("example") MediaExample example);

    int updateByPrimaryKeySelective(Media record);

    int updateByPrimaryKey(Media record);
    
    List<MedGroupByDate> getTalentMediasByTalentId(Integer talentId);
}