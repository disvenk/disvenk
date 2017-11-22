package com.yepao.mapper;

import com.yepao.pojo.ComboComment;
import com.yepao.pojo.ComboCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComboCommentMapper {
    int countByExample(ComboCommentExample example);

    int deleteByExample(ComboCommentExample example);

    int deleteByPrimaryKey(Long comboId);

    int insert(ComboComment record);

    int insertSelective(ComboComment record);

    List<ComboComment> selectByExample(ComboCommentExample example);

    ComboComment selectByPrimaryKey(Long comboId);

    int updateByExampleSelective(@Param("record") ComboComment record, @Param("example") ComboCommentExample example);

    int updateByExample(@Param("record") ComboComment record, @Param("example") ComboCommentExample example);

    int updateByPrimaryKeySelective(ComboComment record);

    int updateByPrimaryKey(ComboComment record);
}