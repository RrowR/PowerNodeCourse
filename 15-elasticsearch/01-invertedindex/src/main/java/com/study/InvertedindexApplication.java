package com.study;

import com.huaban.analysis.jieba.JiebaSegmenter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InvertedindexApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvertedindexApplication.class, args);
    }

    @Bean
    public JiebaSegmenter jiebaSegmenter() {
        return new JiebaSegmenter();
    }
}
