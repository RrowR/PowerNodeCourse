package com.study.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@ConditionalOnClass(DruidDataSource.class)
@ConfigurationProperties(prefix = "own.druid.monitor")
@EnableConfigurationProperties(DataSourceProperties.class)          // 启用springboot里的DataSourceProperties文件
@Data
public class MyDruidAutoConfigure {

    private List<String> list;

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean(initMethod = "init",destroyMethod = "close")  // 这里是 DruidDataSource 所以只能在 DruidDataSource里使用
    public DruidDataSource dataSource(){
        // 创建Druid数据源
        DruidDataSource dataSource = new DruidDataSource();
        // 给DruidDataSource设置初始值，从上面的DataSourceProperties里获取
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        System.out.println("数据源被创建");
        return dataSource;
    }


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
        registrationBean.addInitParameter("loginUsername","root");
        registrationBean.addInitParameter("loginPassword","123456");
        registrationBean.addInitParameter("allow","127.0.0.1");
        registrationBean.addInitParameter("deny","");
        registrationBean.setLoadOnStartup(1);
        // 设置请求的地址
        registrationBean.setUrlMappings(list);
        return registrationBean;
    }
}
