package com.study.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "my.druid")
@Data
public class MyDruidProperties {
    private String url;
    private String driverClassName;
    private String username;
    private String password;
    /**
     * 初始化链接数
     */
    private Integer initialSize;
    /**
     * 最大链接活跃数
     */
    private Integer maxActive;
    /**
     * 最小链接数
     */
    private Integer minIdle;
    /**
     * 检查的sql语句
     */
    private String validationQuery;
    private StatView statView;

    /**
     * 监控配置
     */
    @Data
    static class StatView {
        /**
         * 监控登陆用户名
         */
        private String loginUsername;
        /**
         * 监控登陆密码
         */
        private String loginPassword;
        /**
         * 白名单
         */
        private String allow;
        /**
         * 黑名单
         */
        private String deny;
        /**
         * 映射路径
         */
        private String[] urlMapping;
    }

}
