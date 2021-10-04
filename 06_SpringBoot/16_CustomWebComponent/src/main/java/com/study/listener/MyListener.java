package com.study.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("destory");
    }
}
