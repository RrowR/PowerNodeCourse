package controller;

import entity.Student;
import impl.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/queryAllStudent")
public class queryAllStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.queryAllStudent();
        req.setAttribute("students",students);
        req.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
