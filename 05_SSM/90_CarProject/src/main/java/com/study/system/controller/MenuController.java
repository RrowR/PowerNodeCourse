package com.study.system.controller;

import com.github.pagehelper.Page;
import com.study.system.common.Result;
import com.study.system.domain.Menu;
import com.study.system.dto.MenuDto;
import com.study.system.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    /*
        分页查询
     */
    @RequestMapping("queryForPage.action")
    public Result queryForPage(MenuDto menuDto){
        Page<Menu> page = menuService.queryForPage(menuDto);
        return new Result("查询成功",(int)page.getTotal(),page.getResult());
    }

    @RequestMapping("loadMenuTreeJson.action")
    public Result loadMenuTreeJson(Menu menu){
        List<Menu> menus =  menuService.queryAllMenus();
    }

}
