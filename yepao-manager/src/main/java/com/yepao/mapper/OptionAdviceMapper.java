package com.yepao.mapper;

import com.yepao.pojo.OptionAdvice;
import com.yepao.pojo.OptionAdviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OptionAdviceMapper {
    int countByExample(OptionAdviceExample example);

    int deleteByExample(OptionAdviceExample example);

    int deleteByPrimaryKey(Long optionAdviceId);

    int insert(OptionAdvice record);

    int insertSelective(OptionAdvice record);

    List<OptionAdvice> selectByExample(OptionAdviceExample example);

    OptionAdvice selectByPrimaryKey(Long optionAdviceId);

    int updateByExampleSelective(@Param("record") OptionAdvice record, @Param("example") OptionAdviceExample example);

    int updateByExample(@Param("record") OptionAdvice record, @Param("example") OptionAdviceExample example);

    int updateByPrimaryKeySelective(OptionAdvice record);

    int updateByPrimaryKey(OptionAdvice record);
}