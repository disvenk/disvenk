package com.yepao.mapper;

import com.yepao.pojo.Dishstyle;
import com.yepao.pojo.DishstyleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DishstyleMapper {
    int countByExample(DishstyleExample example);

    int deleteByExample(DishstyleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Dishstyle record);

    int insertSelective(Dishstyle record);

    List<Dishstyle> selectByExample(DishstyleExample example);

    Dishstyle selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Dishstyle record, @Param("example") DishstyleExample example);

    int updateByExample(@Param("record") Dishstyle record, @Param("example") DishstyleExample example);

    int updateByPrimaryKeySelective(Dishstyle record);

    int updateByPrimaryKey(Dishstyle record);
}