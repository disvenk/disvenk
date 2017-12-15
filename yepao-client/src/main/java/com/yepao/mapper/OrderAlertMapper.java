package com.yepao.mapper;

import com.yepao.pojo.OrderAlert;
import com.yepao.pojo.OrderAlertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderAlertMapper {
    int countByExample(OrderAlertExample example);

    int deleteByExample(OrderAlertExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderAlert record);

    int insertSelective(OrderAlert record);

    List<OrderAlert> selectByExample(OrderAlertExample example);

    OrderAlert selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderAlert record, @Param("example") OrderAlertExample example);

    int updateByExample(@Param("record") OrderAlert record, @Param("example") OrderAlertExample example);

    int updateByPrimaryKeySelective(OrderAlert record);

    int updateByPrimaryKey(OrderAlert record);
    
    //新增更改离线消息
    int updateLine(Long hotelId);
}