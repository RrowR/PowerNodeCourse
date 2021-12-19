package com.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableOpenApi          // 开始swagger功能
@EnableConfigurationProperties(SwaggerProperties.class)     // 可以指定别的类添加到Spring容器
public class SwaggerAutoConfiguration {

    @Autowired
    private SwaggerProperties swaggerProperties;

    /*
        创建swagger对象
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(getApiInfo())
                .groupName(swaggerProperties.getGroupName())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
                .build();
    }


    private ApiInfo getApiInfo() {
        Contact contact = new Contact(swaggerProperties.getName(), swaggerProperties.getUrl(), swaggerProperties.getEmail());
        return new ApiInfo(swaggerProperties.getTitle(),
                swaggerProperties.getDescription(),
                swaggerProperties.getVersion(),
                swaggerProperties.getTermsOfServiceUrl(),
                contact,
                swaggerProperties.getLicense(),
                swaggerProperties.getLicenseUrl(),
                new ArrayList<>()
        );
    }



}
