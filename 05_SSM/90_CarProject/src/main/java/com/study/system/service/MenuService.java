package com.study.system.service;

import com.study.system.domain.Menu;

import java.util.List;

public interface MenuService{


    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> queryAllAvailableMenus();
}
