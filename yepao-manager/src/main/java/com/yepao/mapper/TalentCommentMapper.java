package com.yepao.mapper;

import com.yepao.pojo.TalentComment;
import com.yepao.pojo.TalentCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TalentCommentMapper {
    int countByExample(TalentCommentExample example);

    int deleteByExample(TalentCommentExample example);

    int deleteByPrimaryKey(Long talentId);

    int insert(TalentComment record);

    int insertSelective(TalentComment record);

    List<TalentComment> selectByExample(TalentCommentExample example);

    TalentComment selectByPrimaryKey(Long talentId);

    int updateByExampleSelective(@Param("record") TalentComment record, @Param("example") TalentCommentExample example);

    int updateByExample(@Param("record") TalentComment record, @Param("example") TalentCommentExample example);

    int updateByPrimaryKeySelective(TalentComment record);

    int updateByPrimaryKey(TalentComment record);
}