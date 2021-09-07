package com.study;

import com.alibaba.fastjson.JSON;
import com.study.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/students.do")
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("html/json;charset=utf-8");
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student(i, "猫羽雫" + i, "addr" + i, i, 0, new Date());
            students.add(student);
        }
        String JsonArrayString = JSON.toJSONString(students);
        resp.getWriter().write(JsonArrayString);
    }
}
