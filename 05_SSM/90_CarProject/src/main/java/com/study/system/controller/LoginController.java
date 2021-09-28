package com.study.system.controller;

import cn.hutool.crypto.digest.DigestUtil;
import com.study.system.common.Constants;
import com.study.system.common.Result;
import com.study.system.domain.LogLogin;
import com.study.system.domain.User;
import com.study.system.service.LogLoginService;
import com.study.system.service.UserService;
import com.study.system.utils.WebUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/*
    这里需要使用RestController来将对象转换成json对象，前端才能接收，不然前端会认为是一个Object，那边无法获得msg
 */
@RestController
@RequestMapping("login")
public class LoginController {
    @Resource
    private UserService userService;

    @Resource
    private LogLoginService logLoginService;

    /*
        跳转到登录界面
     */
    @RequestMapping("login.action")
    public Result login(String username, String password, String captcha){
        // 密文不能解密，但是可以先加密然后再进行比对
        String pwd = DigestUtil.md5Hex(password.getBytes());
        User user = userService.login(username, pwd);
        if (captcha.equalsIgnoreCase(WebUtils.getSession().getAttribute(Constants.CHECK_CODE_KEY).toString())){
            if (user != null){
                WebUtils.getSession().setAttribute(Constants.CURRENT_SESSION_USER_KEY,user);
                // 在登陆成功的时候记录日志
                logLoginService.insert(new LogLogin(user.getUserid(),user.getRealname()+"-"+user.getLoginname(),WebUtils.getRequest().getRemoteAddr(),new Date()));
                return new Result(200,"登录成功");
            }else {
                return new Result(-1,"用户名或密码不正确");
            }
        }else {
            return new Result(-1,"验证码不正确");
        }
    }


}
