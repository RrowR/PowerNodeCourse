package com.study.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.system.domain.Menu;
import com.study.system.dto.MenuDto;
import com.study.system.mapper.MenuMapper;
import com.study.system.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    @Resource
    private MenuMapper menuMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Menu record) {
        return menuMapper.insert(record);
    }

    @Override
    public int insertSelective(Menu record) {
        return menuMapper.insertSelective(record);
    }

    @Override
    public Menu selectByPrimaryKey(Integer id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return menuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return menuMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Menu> queryAllAvailableMenus() {
        return menuMapper.queryAllAvailableMenus();
    }

    @Override
    public Page<Menu> queryForPage(MenuDto menuDto) {
        Page<Menu> page = PageHelper.startPage(menuDto.getPage(),menuDto.getLimit());
        List<Menu> menuList = menuMapper.queryAllMenu(menuDto);
        return page;
    }

}
