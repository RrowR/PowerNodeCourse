package com.study;

import com.alibaba.fastjson.JSON;
import com.study.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/queryOneStudent.do")
public class QueryOneStudent extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        Student nya = new Student(1, "猫羽雫", "pixiv", 16, 0, new Date());
        String jsonString = JSON.toJSONString(nya);
        writer.write(jsonString);
    }
}
