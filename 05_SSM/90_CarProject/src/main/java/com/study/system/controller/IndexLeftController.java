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
        // 查询 sys_menu 里 available = 1 的全部数据
        List<Menu> menus = menuService.queryAllAvailableMenus();
        // 创建一个Node集合来存储所有Node
        List<Node> nodes = new ArrayList<>();
        // 遍历查出来的每个Menu数据
        for (Menu menu : menus) {
            Node node = new Node();
            BeanUtils.copyProperties(menu,node);
            nodes.add(node);
        }
        ArrayList<Node> resNode = new ArrayList<>();
        for (Node n1 : nodes) {
            // 这里只需要分两层，所以可以先把pid为1的最顶层放进去然后再进行child的添加
            if (n1.getPid().equals(1)){
                resNode.add(n1);
            }
            // 每放进去一个pid为1的对象，就为它添加所有属于它的child
            for (Node n2 : nodes) {
                // n1 的id等于 n2 的pid，可以找到所有的 n1 的子对象
                if (n1.getId().equals(n2.getPid())){
                    n1.getChild().add(n2);
                }
            }
        }
        map.put("menuInfo",resNode);
        return map;
    }
}
