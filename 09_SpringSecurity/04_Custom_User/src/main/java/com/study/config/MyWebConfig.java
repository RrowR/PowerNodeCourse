package com.study.config;

import com.study.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyWebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userService;

    /**
     * @param auth 管理认证的
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 告诉security从实现了UserDetails类去找用户认证信息(告诉security用户的住处)
        auth.userDetailsService(userService);
    }

    /**
     * @param web 管理静态资源的
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) {
        // 这里是放行资源的，不归Security来管理
        web.ignoring().mvcMatchers("/resources/**");
    }

    /**
     * @param http 管理请求的
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
            关闭跨站请求伪造,否则项目页面将无法进行跳转
            因为Security认为这个页面不是我的页面，那么就可能出现关闭跨站请求伪造的可能，所以我们这里需要关闭才可以
         */
        http.csrf().disable();

        // 登陆的请求
        http.formLogin()
                .usernameParameter("uname")
                .passwordParameter("pwd")
                .loginPage("/toLogin")      // 我自己定义的登陆页面路径
                .loginProcessingUrl("/doLogin")      // 登录的url，要和前端对应，这个接口我们不需要写，底层实现了
                .successForwardUrl("/toIndex")      // 登陆成功的去首页
                .failureForwardUrl("/toLogin")         // 登陆失败去登陆
                .permitAll();       // 允许上述的所有请求,不需要认证

        // 请求这个地址是登出
        http.logout().logoutUrl("/doLogout");

        // 其他所有的请求全部拦截
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
