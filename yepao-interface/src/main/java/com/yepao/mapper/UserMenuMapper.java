package com.yepao.mapper;

import com.yepao.pojo.UserMenu;
import com.yepao.pojo.UserMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMenuMapper {
    int countByExample(UserMenuExample example);

    int deleteByExample(UserMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserMenu record);

    int insertSelective(UserMenu record);

    List<UserMenu> selectByExample(UserMenuExample example);

    UserMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserMenu record, @Param("example") UserMenuExample example);

    int updateByExample(@Param("record") UserMenu record, @Param("example") UserMenuExample example);

    int updateByPrimaryKeySelective(UserMenu record);

    int updateByPrimaryKey(UserMenu record);
}