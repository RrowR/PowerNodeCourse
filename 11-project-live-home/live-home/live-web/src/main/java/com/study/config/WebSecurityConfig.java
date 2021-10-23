package com.study.config;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.common.Result;
import com.study.constant.LoginConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.PrintWriter;
import java.time.Duration;
import java.util.UUID;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 忽略拦截的请求路径
        web.ignoring().mvcMatchers("/swagger-ui/**",
                "/druid/**"

        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭跨域请求伪造
        http.csrf().disable();
        http.formLogin()
                .loginProcessingUrl("/doLogin")
                .successHandler(successHandler())
                .failureHandler(failHandler())
                .permitAll();       // 其余的直接放行

        // 设置放行的请求地址
        http.authorizeRequests()
                .antMatchers("/getBanner", "/hotProductOrRecommendation")
                .permitAll();

        http.authorizeRequests().anyRequest().authenticated();
    }

    private AuthenticationFailureHandler failHandler() {
        return (request, response, exception) -> {
            response.setContentType("application/json;charset=utf-8");
            // TODO 登陆失败也需要记录日志
            Result<String> result = new Result<>();
            result.setCode(401);
            result.setData("用户名或密码错误");
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(request);
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
            String token = UUID.randomUUID().toString().replace("-", "");
            // 每次登陆成功，都会存入一个 <token:uuid, authentication> 每个登陆成功的用户都会有自己的token
            redisTemplate.opsForValue().set(LoginConstant.LOGIN_PREFIX + token, JSON.toJSONString(authentication), Duration.ofDays(7));
            // TODO 登陆需要记录日志
            Result<String> result = Result.success("ok", token);
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(result);
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write(s);
            writer.flush();
            writer.close();
        };
    }


}
