package com.yepao.mapper;

import com.yepao.pojo.TalentReserved;
import com.yepao.pojo.TalentReservedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TalentReservedMapper {
    int countByExample(TalentReservedExample example);

    int deleteByExample(TalentReservedExample example);

    int deleteByPrimaryKey(Long talentReservedId);

    int insert(TalentReserved record);

    int insertSelective(TalentReserved record);

    List<TalentReserved> selectByExample(TalentReservedExample example);

    TalentReserved selectByPrimaryKey(Long talentReservedId);

    int updateByExampleSelective(@Param("record") TalentReserved record, @Param("example") TalentReservedExample example);

    int updateByExample(@Param("record") TalentReserved record, @Param("example") TalentReservedExample example);

    int updateByPrimaryKeySelective(TalentReserved record);

    int updateByPrimaryKey(TalentReserved record);
}