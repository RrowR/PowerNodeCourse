package com.study.system.controller;

import com.study.system.common.HomeInfo;
import com.study.system.common.LogoInfo;
import com.study.system.common.Node;
import com.study.system.domain.Menu;
import com.study.system.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("index")
public class IndexLeftController {

    @Resource
    private MenuService menuService;

    @Resource
    private HomeInfo homeInfo;
    @Resource
    private LogoInfo logoInfo;

    @RequestMapping("getIndexLeftMenu.action")
    public Object getIndexLeftMenus(){
        // 仔细观察这个init.json文件是一个map结构的文件，所以我们可以添加创建一个map来自己组装
        HashMap<String, Object> map = new HashMap<>();
        map.put("homeInfo",homeInfo);
        map.put("logoInfo",logoInfo);
        // 查询所有可用菜单
        List<Menu> menus = menuService.queryAllAvailableMenus();
        // 创建一个nodes集合，里面的数据类型和
        List<Node> nodes = new ArrayList<>();
        for (Menu menu : menus) {
            Node node = new Node();
            BeanUtils.copyProperties(menu,node);
            nodes.add(node);
        }
        

        map.put("menuInfo",new ArrayList<>());
        return map;
    }
}
