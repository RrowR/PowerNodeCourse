package com.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)          // 开启方法级别的校验
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 进行权限配置
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("hxd")
                .password(passwordEncoder().encode("hxd"))
                .authorities("sec:add","sec:del","sec:update","sec:query")
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("123456"))
                .authorities("sec:query");
    }

    // 配置请求权限
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 登录成功和失败后跳转的页面
        http.formLogin().successForwardUrl("/welcome")
                .failureForwardUrl("/fail");

        // 使用注解的方式让任意的请求需要登录才可以
        http.authorizeRequests().anyRequest().authenticated();


    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
