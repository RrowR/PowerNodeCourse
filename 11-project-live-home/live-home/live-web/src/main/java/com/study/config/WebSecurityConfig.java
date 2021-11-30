package com.study.config;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.common.Result;
import com.study.constant.LoginConstant;
import com.study.filter.TokenCheckFilter;
import com.study.service.LoginLogService;
import com.study.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.PrintWriter;
import java.time.Duration;
import java.util.UUID;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private TokenCheckFilter tokenCheckFilter;

    @Autowired
    private LoginLogService loginLogService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    public void configure(WebSecurity web) {
        // 忽略拦截的请求路径
        web.ignoring().antMatchers(
                "/swagger-ui/*",
                "/swagger-resources/**",
                "/v2/api-docs",
                "/v3/api-docs",
                "/webjars/**",
                "/druid/**");
    }

    /**
     * 网络请求的配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO 过滤器放到之前吗？
        http.addFilterBefore(tokenCheckFilter, UsernamePasswordAuthenticationFilter.class);
        // 关闭跨域请求伪造
        http.csrf().disable();
        http.cors().disable();
        // 在进入项目的时候需要进行登录
        http.formLogin()
                .loginProcessingUrl("/doLogin")
                .successHandler(successHandler())
                .failureHandler(failHandler())
                .permitAll();       // 允许上面的请求

        // 设置放行的请求地址
        http.authorizeRequests()
                .antMatchers(LoginConstant.ALLOW_URL)
                .permitAll();
        http.authorizeRequests().anyRequest().authenticated();

    }

    private AuthenticationFailureHandler failHandler() {
        return (request, response, exception) -> {
            response.setContentType("application/json;charset=utf-8");
            // TODO 登陆失败也需要记录日志
            loginLogService.addLoginLog(0,MyThreadLocal.threadLocal.get());

            Result<String> result = new Result<>();
            result.setCode(401);
            result.setMsg("用户名或密码错误");

            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(result);
            PrintWriter writer = response.getWriter();
            writer.write(s);
            writer.flush();
            writer.close();
        };
    }

    // 登陆成功的处理器
    private AuthenticationSuccessHandler successHandler() {
        return (httpServletRequest, httpServletResponse, authentication) -> {
            httpServletResponse.setContentType("application/json;charset=utf-8");
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            // 每次登陆成功，都会存入一个 <token:uuid, authentication> 每个登陆成功的用户都会有自己的token
            redisTemplate.opsForValue().set(LoginConstant.LOGIN_PREFIX + token, JSON.toJSONString(authentication), Duration.ofDays(7));
            // TODO 登陆需要记录日志
            loginLogService.addLoginLog(1,MyThreadLocal.threadLocal.get());
            Result<String> result = Result.success("ok", token);
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(result);
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write(s);
            writer.flush();
            writer.close();
        };
    }

    // 设置密码解析器
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
