package com.yepao.mapper;

import com.yepao.pojo.CelebrationPicture;
import com.yepao.pojo.CelebrationPictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CelebrationPictureMapper {
    int countByExample(CelebrationPictureExample example);

    int deleteByExample(CelebrationPictureExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CelebrationPicture record);

    int insertSelective(CelebrationPicture record);

    List<CelebrationPicture> selectByExample(CelebrationPictureExample example);

    CelebrationPicture selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CelebrationPicture record, @Param("example") CelebrationPictureExample example);

    int updateByExample(@Param("record") CelebrationPicture record, @Param("example") CelebrationPictureExample example);

    int updateByPrimaryKeySelective(CelebrationPicture record);

    int updateByPrimaryKey(CelebrationPicture record);
}