package com.yepao.mapper;

import com.yepao.pojo.Clientmenu;
import com.yepao.pojo.ClientmenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClientmenuMapper {
    int countByExample(ClientmenuExample example);

    int deleteByExample(ClientmenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Clientmenu record);

    int insertSelective(Clientmenu record);

    List<Clientmenu> selectByExample(ClientmenuExample example);

    Clientmenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Clientmenu record, @Param("example") ClientmenuExample example);

    int updateByExample(@Param("record") Clientmenu record, @Param("example") ClientmenuExample example);

    int updateByPrimaryKeySelective(Clientmenu record);

    int updateByPrimaryKey(Clientmenu record);
}