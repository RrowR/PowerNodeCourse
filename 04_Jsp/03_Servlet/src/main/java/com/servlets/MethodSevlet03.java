package com.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Servlet请求的第三种方式
 */
@WebServlet(value = {"/page04.wangye","/page03.wangye"})
public class MethodSevlet03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet3有请求了...");
        System.out.println(req.getClass().getSimpleName());
        System.out.println(resp.getClass().getSimpleName());
        // 设置浏览器解析的编码格式
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("访问成功");
    }
}
