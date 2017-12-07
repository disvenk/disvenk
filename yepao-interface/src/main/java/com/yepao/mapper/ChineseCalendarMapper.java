package com.yepao.mapper;

import com.yepao.pojo.ChineseCalendar;
import com.yepao.pojo.ChineseCalendarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChineseCalendarMapper {
    int countByExample(ChineseCalendarExample example);

    int deleteByExample(ChineseCalendarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChineseCalendar record);

    int insertSelective(ChineseCalendar record);

    List<ChineseCalendar> selectByExample(ChineseCalendarExample example);

    ChineseCalendar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChineseCalendar record, @Param("example") ChineseCalendarExample example);

    int updateByExample(@Param("record") ChineseCalendar record, @Param("example") ChineseCalendarExample example);

    int updateByPrimaryKeySelective(ChineseCalendar record);

    int updateByPrimaryKey(ChineseCalendar record);
}