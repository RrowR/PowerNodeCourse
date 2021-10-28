package com.study.feign.hystrix;

import com.study.feign.ProviderFeign;
import org.springframework.stereotype.Component;


/**
 *  写一个类去实现Feign接口作为备胎方法
 */
@Component
public class ConsumerHystrix implements ProviderFeign {
    @Override
    public String makeFood() {
        return "我是备胎方案";
    }
}
