package com.yepao.mapper;

import com.yepao.pojo.Celebration;
import com.yepao.pojo.CelebrationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CelebrationMapper {
    int countByExample(CelebrationExample example);

    int deleteByExample(CelebrationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Celebration record);

    int insertSelective(Celebration record);

    List<Celebration> selectByExample(CelebrationExample example);

    Celebration selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Celebration record, @Param("example") CelebrationExample example);

    int updateByExample(@Param("record") Celebration record, @Param("example") CelebrationExample example);

    int updateByPrimaryKeySelective(Celebration record);

    int updateByPrimaryKey(Celebration record);
}