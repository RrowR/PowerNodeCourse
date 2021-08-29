package controller;

import dao.StudentDao;
import entity.Student;
import impl.StudentDaoImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/queryAllStudents")
public class getAllStudent extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.queryAllStudent();
        req.setAttribute("students",students);
        System.out.println("doServer执行...");
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
