package com.yepao.mapper;

import com.yepao.pojo.AppointmentPayed;
import com.yepao.pojo.AppointmentPayedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppointmentPayedMapper {
    int countByExample(AppointmentPayedExample example);

    int deleteByExample(AppointmentPayedExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppointmentPayed record);

    int insertSelective(AppointmentPayed record);

    List<AppointmentPayed> selectByExample(AppointmentPayedExample example);

    AppointmentPayed selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppointmentPayed record, @Param("example") AppointmentPayedExample example);

    int updateByExample(@Param("record") AppointmentPayed record, @Param("example") AppointmentPayedExample example);

    int updateByPrimaryKeySelective(AppointmentPayed record);

    int updateByPrimaryKey(AppointmentPayed record);
}