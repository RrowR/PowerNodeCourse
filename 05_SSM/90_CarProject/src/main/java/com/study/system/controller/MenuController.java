package com.study.system.controller;

import com.github.pagehelper.Page;
import com.study.system.common.Result;
import com.study.system.common.TreeNode;
import com.study.system.domain.Menu;
import com.study.system.dto.MenuDto;
import com.study.system.service.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    /*
        封装treeNodes数据
     */
    @RequestMapping("loadMenuTreeJson.action")
    public Result loadMenuTreeJson(Menu menu){
        List<Menu> menus =  menuService.queryAllMenusForDtree(menu);
        List<TreeNode> treeNodes = new ArrayList<>();
        for (Menu m : menus) {
            treeNodes.add(new TreeNode(m.getId(),m.getPid(),m.getTitle()));
        }
        return new Result("查询成功",treeNodes.size(),treeNodes);
    }

    @RequestMapping("add.action")
    public Result add(Menu menu){
        int i = menuService.insertSelective(menu);
        if (i > 0){
            return new Result(200,"插入成功");
        }else {
            return new Result(200,"插入失败");
        }
    }

    @RequestMapping("update.action")
    public Result update(Menu menu){
        int i = menuService.updateByPrimaryKeySelective(menu);
        if (i > 0){
            return new Result(200,"更新成功");
        }else {
            return new Result(200,"更新失败");
        }
    }

    @RequestMapping("delete.action")
    public Result delete(Integer id){
        int i = menuService.deleteByPrimaryKey(id);
        if (i > 0){
            return new Result(200,"删除成功");
        }else {
            return new Result(200,"删除失败");
        }
    }



}
