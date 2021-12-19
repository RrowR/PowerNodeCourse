package com.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("hxd").setViewName("hello");
        registry.addViewController("hello").setViewName("hello");
    }

    /*
            添加自定义的拦截器
         */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器，设置拦截路径，设置排除的路径
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/hello","/hxd");
    }
}
