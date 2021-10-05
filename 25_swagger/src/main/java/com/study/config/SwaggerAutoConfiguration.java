package com.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.oas.annotations.EnableOpenApi;

@Configuration
@EnableOpenApi          // 开始swagger功能
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerAutoConfiguration {

    @Autowired
    private SwaggerProperties swaggerProperties;

}
