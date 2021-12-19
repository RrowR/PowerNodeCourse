package com.study.controller;

import com.study.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "用户管理接口")
public class UserController {

    @GetMapping("getUser/{id}")
    @ApiOperation("根据id获取英雄")
    @ApiImplicitParam(name = "id", value = "用户编号(必填)", required = true, dataType = "Integer", paramType = "path")
    public User getUserById(Integer id){
        HashMap<String, String> map = new HashMap<>();
        map.put("技能", "射箭");
        return new User(id, "后裔", "峡谷", new Date(), Arrays.asList("打猎"), map);
    }

    @PostMapping("addUser")
    @ApiOperation("添加英雄")
    public Map<String, Object> addHero(@RequestBody User user) {
        System.out.println(user);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "OK");
        return map;
    }

    @DeleteMapping("delUser")
    @ApiOperation("根据id删除一个用户")
    @ApiImplicitParam(name = "id", value = "英雄编号", required = true, paramType = "query", dataType = "Integer")
    public Map<String, Object> delHero(@RequestParam Integer id) {
        System.out.println(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "OK");
        return map;
    }


}
