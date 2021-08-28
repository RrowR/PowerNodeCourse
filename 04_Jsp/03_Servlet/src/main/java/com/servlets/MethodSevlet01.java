package com.servlets;


import javax.servlet.*;
import java.io.IOException;

/**
 *  Servlet请求的第一种方式
 *  实现Servlet接口
 */
public class MethodSevlet01 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet1有请求了...");
        System.out.println(servletRequest.getClass().getSimpleName());
        System.out.println(servletResponse.getClass().getSimpleName());
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
