package servlets;

import dao.StudentDao;
import entity.Student;
import impl.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/queryAll.do")
public class QueryAllStudent extends HttpServlet {
    private StudentDao studentDao = new StudentDaoImpl();
    private SimpleDateFormat sdf = new SimpleDateFormat();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getAttribute("failcode");
        List<Student> students = studentDao.queryAllStudent();
        req.getSession().setAttribute("students",students);
        resp.sendRedirect("list.jsp");
    }
}
