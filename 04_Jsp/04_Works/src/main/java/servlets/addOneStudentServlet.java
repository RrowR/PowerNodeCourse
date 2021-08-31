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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addStudentServlet.do")
public class addOneStudentServlet extends HttpServlet {
    private StudentDao studentDao = new StudentDaoImpl();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        Integer age = Integer.valueOf(request.getParameter("age"));
        Integer sex = Integer.valueOf(request.getParameter("sex"));
        String birth = request.getParameter("birth");
        try {
            Date date = sdf.parse(birth);
            studentDao.addStudent(new Student(name,address,age,sex,date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        response.sendRedirect("queryAll.do");
    }
}
