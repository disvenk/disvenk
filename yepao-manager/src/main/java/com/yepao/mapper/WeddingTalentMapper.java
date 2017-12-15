package com.yepao.mapper;

import com.yepao.pojo.WeddingTalent;
import com.yepao.pojo.WeddingTalentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeddingTalentMapper {
    int countByExample(WeddingTalentExample example);

    int deleteByExample(WeddingTalentExample example);

    int deleteByPrimaryKey(Long weddingTalentId);

    int insert(WeddingTalent record);

    int insertSelective(WeddingTalent record);

    List<WeddingTalent> selectByExample(WeddingTalentExample example);

    WeddingTalent selectByPrimaryKey(Long weddingTalentId);

    int updateByExampleSelective(@Param("record") WeddingTalent record, @Param("example") WeddingTalentExample example);

    int updateByExample(@Param("record") WeddingTalent record, @Param("example") WeddingTalentExample example);

    int updateByPrimaryKeySelective(WeddingTalent record);

    int updateByPrimaryKey(WeddingTalent record);
}