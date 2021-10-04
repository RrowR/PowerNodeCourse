package com.study.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@ConditionalOnClass(DruidDataSource.class)
@ConfigurationProperties(prefix = "own.druid.monitor")
@Data
public class MyDruidAutoConfigure {

    private List<String> list;




    /*
        动态管理创建druid的数据源监控
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> registrationBean(){
        // 创建alibaba数据源监控Servlet对象
        StatViewServlet statViewServlet = new StatViewServlet();
        // 创建Servlet注册对象
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>();
        // 给注册对象设置Servlet
        registrationBean.setServlet(statViewServlet);
        registrationBean.addInitParameter("username","root");
        registrationBean.addInitParameter("password","123456");
        registrationBean.addInitParameter("allow","127.0.0.1");
        registrationBean.addInitParameter("deny","");
        registrationBean.setLoadOnStartup(1);
        // 设置请求的地址
        registrationBean.setUrlMappings(list);
        return registrationBean;
    }
}
