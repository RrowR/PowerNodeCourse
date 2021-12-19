package com.study.logback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class LogbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogbackApplication.class, args);
        log.trace("这是一个Trace日志");
        log.info("这是一个info日志");
        log.warn("这是一个warn日志");
        log.debug("这是一个debug日志");
        log.error("这是一个error日志");

    }

}
