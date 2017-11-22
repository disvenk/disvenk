package com.yepao.mapper;

import com.yepao.pojo.CelebrationComment;
import com.yepao.pojo.CelebrationCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CelebrationCommentMapper {
    int countByExample(CelebrationCommentExample example);

    int deleteByExample(CelebrationCommentExample example);

    int deleteByPrimaryKey(Long celebrationId);

    int insert(CelebrationComment record);

    int insertSelective(CelebrationComment record);

    List<CelebrationComment> selectByExample(CelebrationCommentExample example);

    CelebrationComment selectByPrimaryKey(Long celebrationId);

    int updateByExampleSelective(@Param("record") CelebrationComment record, @Param("example") CelebrationCommentExample example);

    int updateByExample(@Param("record") CelebrationComment record, @Param("example") CelebrationCommentExample example);

    int updateByPrimaryKeySelective(CelebrationComment record);

    int updateByPrimaryKey(CelebrationComment record);
}