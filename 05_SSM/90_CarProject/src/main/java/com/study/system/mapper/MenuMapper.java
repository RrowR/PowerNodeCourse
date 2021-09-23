package com.study.system.mapper;

import com.github.pagehelper.Page;
import com.study.system.domain.Menu;
import com.study.system.dto.MenuDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    // 查询所有可用的菜单
    List<Menu> queryAllAvailableMenus();

    List<Menu> queryAllMenu(@Param("menuDto") MenuDto menuDto);
}