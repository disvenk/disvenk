package com.yepao.mapper;

import com.yepao.pojo.Celebrationpicture;
import com.yepao.pojo.CelebrationpictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CelebrationpictureMapper {
    int countByExample(CelebrationpictureExample example);

    int deleteByExample(CelebrationpictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Celebrationpicture record);

    int insertSelective(Celebrationpicture record);

    List<Celebrationpicture> selectByExample(CelebrationpictureExample example);

    Celebrationpicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Celebrationpicture record, @Param("example") CelebrationpictureExample example);

    int updateByExample(@Param("record") Celebrationpicture record, @Param("example") CelebrationpictureExample example);

    int updateByPrimaryKeySelective(Celebrationpicture record);

    int updateByPrimaryKey(Celebrationpicture record);
}