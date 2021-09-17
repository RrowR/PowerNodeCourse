package com.study.system.controller;

import cn.hutool.captcha.CircleCaptcha;
import com.study.system.common.Constants;
import com.study.system.utils.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("captcha")
public class CaptchaController {
    @RequestMapping("captcha.action")
    public void captcha(HttpServletResponse response) throws IOException {
        // 创建一个 captcha 对象
        CircleCaptcha captcha = new CircleCaptcha(100, 40, 1, 2);
        // 得到验证码
        String code = captcha.getCode();
        // 将验证码放到Session中,session是可以退出的，所以不建议放到request或者application中
        WebUtils.getSession().setAttribute(Constants.CHECK_CODE_KEY,code);
        // 将图片写出到response页面中去
        captcha.write(response.getOutputStream());
    }
}
