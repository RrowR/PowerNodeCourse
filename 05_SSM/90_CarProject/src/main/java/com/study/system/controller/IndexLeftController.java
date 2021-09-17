package com.study.system.controller;

import com.study.system.common.HomeInfo;
import com.study.system.common.LogoInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("index")
public class IndexLeftController {

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
        map.put("menuInfo",new ArrayList<>());
        return map;
    }
}
