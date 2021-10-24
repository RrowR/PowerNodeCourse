package com.study.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.PrintWriter;
import java.util.HashMap;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)      // 开启方法级别的校验
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 设置内存级别的权限账号
        auth.inMemoryAuthentication()
                .withUser("hxd")
                .password(passwordEncoder().encode("123456"))
                .authorities("auth:add", "auth:del")
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("123456"))
                .roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

//        // 前后端不分离可以这么写
//        http.formLogin()
//                .successForwardUrl("/success")
//                .failureForwardUrl("/fail")
//                .permitAll();
//

        // 异常处理器
        http.exceptionHandling()
                .accessDeniedHandler(isDenied());       // 处理异常的处理器，这样就会覆盖掉跳转到默认的error的静态资源页面

        http.formLogin()
                .successHandler(isSuccess())       // 登陆成功的处理器，返回一组数据
                .failureHandler(isFail())          // 登陆失败的处理器
                .permitAll();

        // 其他任意请求都需要登录
        http.authorizeRequests().anyRequest().authenticated();
    }

    private AccessDeniedHandler isDenied() {
        return (request, response, accessDeniedException) -> {
            response.setContentType("application/json;charset=utf-8");
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",HttpStatus.FORBIDDEN.value());
            map.put("msg","您的权限不够");
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(map);
            PrintWriter writer = response.getWriter();
            writer.write(s);
            writer.flush();
            writer.close();
        };
    }

    private AuthenticationFailureHandler isFail() {
        return (request, response, exception) -> {
            response.setContentType("application/json;charset=utf-8");
            HashMap<String, Object> map = new HashMap<>(4);
            map.put("code", HttpStatus.UNAUTHORIZED);
            if (exception instanceof LockedException) {
                map.put("msg", "账户被锁定，登陆失败！");
            } else if (exception instanceof BadCredentialsException) {
                map.put("msg", "账户或者密码错误，登陆失败！");
            } else if (exception instanceof DisabledException) {
                map.put("msg", "账户被禁用，登陆失败！");
            } else if (exception instanceof AccountExpiredException) {
                map.put("msg", "账户已过期，登陆失败！");
            } else if (exception instanceof CredentialsExpiredException) {
                map.put("msg", "密码已过期，登陆失败！");
            } else {
                map.put("msg", "登陆失败！");
            }
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(map);
            PrintWriter writer = response.getWriter();
            writer.write(s);
            writer.flush();
            writer.close();


        };
    }

    private AuthenticationSuccessHandler isSuccess() {
        // 这个方法实现了  onAuthenticationSuccess 方法
        return (request, response, authentication) -> {
            response.setContentType("application/json;charset=utf-8");
            HashMap<String, Object> map = new HashMap<>(8);
            map.put("code",200);
            map.put("msg","ok");
            map.put("data",authentication);
            // 获取写的流
            PrintWriter writer = response.getWriter();
            // 这个是jackson里的方法
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(map);
            writer.write(s);
            writer.flush();
            writer.close();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
