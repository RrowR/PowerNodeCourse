package com.study.system.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 *  创建监听器
 */
@WebListener
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // 在容器加载的时候就把地址放到全局作用域里(application)
        ServletContext servletContext = servletContextEvent.getServletContext();
        // 放入当前项目路径地址到最大的Application中去
        servletContext.setAttribute("ctx",servletContext.getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
