package com.study.system.service;

import com.github.pagehelper.Page;
import com.study.system.domain.Menu;
import com.study.system.dto.MenuDto;

import java.util.List;

public interface MenuService{


    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> queryAllAvailableMenus();

    Page<Menu> queryForPage(MenuDto menuDto);

    List<Menu> queryAllMenusForDtree(Menu menu);
}
