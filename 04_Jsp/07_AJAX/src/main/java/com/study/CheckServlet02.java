package com.study;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/load.do")
public class CheckServlet02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<String> names = new ArrayList<>();
        names.add("zhangsan");
        names.add("lisi");
        names.add("wangwu");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        PrintWriter writer = resp.getWriter();
        if (names.contains(username)){
            writer.write("用户名重复");
        }else {
            writer.write("此用户名可以使用");
        }
    }
}
