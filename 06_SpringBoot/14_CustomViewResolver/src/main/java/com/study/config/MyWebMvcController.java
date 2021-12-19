package com.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcController implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 重定向控制器注册
        registry.addRedirectViewController("/tobaidu","https://www.bilibili.com/");
        // 注册转发控制器
        registry.addViewController("/test").setViewName("test");
    }
}
