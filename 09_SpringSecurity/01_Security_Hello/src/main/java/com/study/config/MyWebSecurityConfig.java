package com.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("hxd")
                .password(passwordEncoder().encode("hxd"))          // 这里只能加密不能解密，然后进行输入验证
                .roles("ADMIN")
                .authorities("sys:add","sys:del","sys:update","sys:query")      // 设置权限
                .and()
                .withUser("hxh")
                .password(passwordEncoder().encode("hxh"))
                .roles("TEST")
                .authorities("sys:query")
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("123456"))
                .roles("ADMINdasdasdas");           // 一旦给角色设置权限，那么角色就消失了
    }

    /*
        配置http请求认证
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .successForwardUrl("/welcome")
                .failureForwardUrl("/fail");

        // 对接口进行权限控制
        http.authorizeRequests()
                .antMatchers("/add").hasAnyAuthority("sys:add")
                .antMatchers("/del").hasAnyAuthority("sys:del")
                .antMatchers("/update").hasAnyAuthority("sys:update")
                .antMatchers("/query").hasAnyAuthority("sys:query");



        // 放行控制
        http.authorizeRequests()
                .antMatchers("/free")
                .permitAll();

        // 其他请求只有登录了才能进行
        http.authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
