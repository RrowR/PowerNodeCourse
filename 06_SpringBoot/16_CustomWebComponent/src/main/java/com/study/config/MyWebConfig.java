package com.study.config;

import com.study.filter.MyFilter;
import com.study.listener.MyListener;
import com.study.servlet.UserServlet;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "servlet")
@Data
public class MyWebConfig {

    @Autowired
    private UserServlet myServlet;

    @Autowired
    private MyFilter myFilter;

    @Autowired
    private MyListener myListener;

    private List<String> servlet01Mappings;

    @Bean
    public ServletRegistrationBean<UserServlet> servletServletRegistrationBean(){
        ServletRegistrationBean<UserServlet> registrationBean = new ServletRegistrationBean<>();
        // 添加自定义的Servlet
        registrationBean.setServlet(myServlet);
//        registrationBean.addUrlMappings("/own");
        // 使用配置文件的方式动态改servlet请求路径
        registrationBean.setUrlMappings(servlet01Mappings);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter> filterFilterRegistrationBean(){
        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(myFilter);
        // 所有的请求都走过滤器   /不会过滤页面，只会过滤路径   /*会过滤路径和页面
        registrationBean.setUrlPatterns(Arrays.asList("*.do"));
        return registrationBean;
    }

    /*
        ServletListenerRegistrationBean 设置监听器，其实这里设不设置都无所谓
        如果已经将监听器放到IOC容器里了则不需要配置
     */
    @Bean
    public ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>();
        registrationBean.setListener(myListener);
        return registrationBean;
    }


}
