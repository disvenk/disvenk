package com.yepao.mapper;

import com.yepao.pojo.SyntheComment;
import com.yepao.pojo.SyntheCommentExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyntheCommentMapper {
    int countByExample(SyntheCommentExample example);

    int deleteByExample(SyntheCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyntheComment record);

    int insertSelective(SyntheComment record);

    List<SyntheComment> selectByExample(SyntheCommentExample example);

    SyntheComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyntheComment record, @Param("example") SyntheCommentExample example);

    int updateByExample(@Param("record") SyntheComment record, @Param("example") SyntheCommentExample example);

    int updateByPrimaryKeySelective(SyntheComment record);

    int updateByPrimaryKey(SyntheComment record);
    
    BigDecimal getAvgComment(); 
}