package com.servlets;


import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Servlet请求的第二种方式
 *  继承实现了Servlet的接口
 */
public class MethodSevlet02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet2有请求了...");
        System.out.println(req.getClass().getSimpleName());
        System.out.println(resp.getClass().getSimpleName());
    }
}
