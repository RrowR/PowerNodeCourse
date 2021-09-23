package com.study.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    /*
         跳转到登录页
      */
    @RequestMapping("toLogin.action")
    public String login(){
        return "main/login";
    }

    /*
        跳转到首页
     */
    @RequestMapping("index.action")
    public String index(){
        return "main/index";
    }

    /*
        跳转到工作台
     */
    @RequestMapping("toWelcome.action")
    public String toWelcome(){
        return "main/welcome";
    }

    /*
        日志管理
     */
    @RequestMapping("toLogInfoManager.action")
    public String logInfoManager(){
        return "system/loginfo/list";
    }

    /*
        跳转到公告管理
     */
    @RequestMapping("toNewsManager.action")
    public String toLoginInfoManager(){
        return "system/news/list";
    }

    /*
        菜单管理
     */
    @RequestMapping("toMenuManager.action")
    public String toMenuManager(){
        return "system/menu/manager";
    }

    /*
        左侧菜单管理
     */
    @RequestMapping("toLeftMenuManager.action")
    public String toLeftMenuManager(){
        return "system/menu/managerLeftManager";
    }

    /*
        右侧菜单管理
     */
    @RequestMapping("toRightMenuManager.action")
    public String toRightMenuManager(){
        return "system/menu/managerRightManager";
    }


}
