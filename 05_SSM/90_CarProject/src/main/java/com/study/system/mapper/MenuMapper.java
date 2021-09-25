package com.study.system.mapper;

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

    /*
    *  这里在使用id查询的时候不仅要根据主id进行查询，还需要查询子节点
    *  */
    List<Menu> queryAllMenusForDtree(@Param("menu") Menu menu);

    int queryMenuCountByPid(@Param("id") Integer id);

    void deleteMenuRoleByMid(@Param("id") Integer id);
}