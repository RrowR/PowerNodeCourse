package com.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
                .authorities("sys:query");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
