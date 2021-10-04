package com.study.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(MyDruidProperties.class)
@ConditionalOnClass(DataSource.class)
public class MyDruidAutoConfiguration {

    @Autowired
    private MyDruidProperties myDruidProperties;

    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource druidDataSource() {
        if (!StringUtils.hasText(myDruidProperties.getUrl())) {
            throw new IllegalArgumentException("URL 不能为空");
        }
        DruidDataSource druidDataSource = new DruidDataSource();
        // 设置参数
        druidDataSource.setUrl(myDruidProperties.getUrl());
        druidDataSource.setUsername(myDruidProperties.getUsername());
        druidDataSource.setPassword(myDruidProperties.getPassword());
        druidDataSource.setDriverClassName(myDruidProperties.getDriverClassName());
        druidDataSource.setMaxActive(myDruidProperties.getMaxActive());
        druidDataSource.setInitialSize(myDruidProperties.getInitialSize());
        druidDataSource.setMinIdle(myDruidProperties.getMinIdle());
        druidDataSource.setValidationQuery(myDruidProperties.getValidationQuery());
        return druidDataSource;
    }

    /**
     * 注册servlet
     *
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> registrationBean() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>();
        registrationBean.setServlet(statViewServlet);
        // 设置参数
        registrationBean.addInitParameter("loginUsername", myDruidProperties.getStatView().getLoginUsername());
        registrationBean.addInitParameter("loginPassword", myDruidProperties.getStatView().getLoginPassword());
        registrationBean.addInitParameter("allow", myDruidProperties.getStatView().getAllow());
        registrationBean.addInitParameter("deny", myDruidProperties.getStatView().getDeny());
        registrationBean.addUrlMappings(myDruidProperties.getStatView().getUrlMapping());
        return registrationBean;
    }
}
