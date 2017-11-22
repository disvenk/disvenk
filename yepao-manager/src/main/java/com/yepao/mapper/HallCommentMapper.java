package com.yepao.mapper;

import com.yepao.pojo.HallComment;
import com.yepao.pojo.HallCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HallCommentMapper {
    int countByExample(HallCommentExample example);

    int deleteByExample(HallCommentExample example);

    int deleteByPrimaryKey(Long hallId);

    int insert(HallComment record);

    int insertSelective(HallComment record);

    List<HallComment> selectByExample(HallCommentExample example);

    HallComment selectByPrimaryKey(Long hallId);

    int updateByExampleSelective(@Param("record") HallComment record, @Param("example") HallCommentExample example);

    int updateByExample(@Param("record") HallComment record, @Param("example") HallCommentExample example);

    int updateByPrimaryKeySelective(HallComment record);

    int updateByPrimaryKey(HallComment record);
}