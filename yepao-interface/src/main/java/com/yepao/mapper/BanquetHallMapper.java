package com.yepao.mapper;

import com.yepao.pojo.BanquetHall;
import com.yepao.pojo.BanquetHallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BanquetHallMapper {
    int countByExample(BanquetHallExample example);

    int deleteByExample(BanquetHallExample example);

    int deleteByPrimaryKey(Long banquetHallId);

    int insert(BanquetHall record);

    int insertSelective(BanquetHall record);

    List<BanquetHall> selectByExample(BanquetHallExample example);

    BanquetHall selectByPrimaryKey(Long banquetHallId);

    int updateByExampleSelective(@Param("record") BanquetHall record, @Param("example") BanquetHallExample example);

    int updateByExample(@Param("record") BanquetHall record, @Param("example") BanquetHallExample example);

    int updateByPrimaryKeySelective(BanquetHall record);

    int updateByPrimaryKey(BanquetHall record);
}