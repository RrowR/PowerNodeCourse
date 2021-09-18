package com.study.system.controller;

import com.study.system.common.HomeInfo;
import com.study.system.common.LogoInfo;
import com.study.system.common.Node;
import com.study.system.domain.Menu;
import com.study.system.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
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
        // 查询 sys_menu 里 available = 1 的全部数据
        List<Menu> menus = menuService.queryAllAvailableMenus();

        // 创建一个Node集合来存储所有Node
        List<Node> nodes = new ArrayList<>();
        // 遍历查出来的每个Menu数据
        for (Menu m1 : menus) {
            Node node = new Node();
            for (Menu m2 : menus) {
                if (m1.getPid().equals(m2.getId())){

                }
            }
        }
        


        

        map.put("menuInfo",new ArrayList<>());
        return map;
    }
}
