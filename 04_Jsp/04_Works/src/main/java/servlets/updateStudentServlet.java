package servlets;

import dao.StudentDao;
import entity.Student;
import impl.StudentDaoImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/updateStudent.do")
public class updateStudentServlet extends HttpServlet {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;utf-8");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        Integer age = Integer.valueOf(request.getParameter("age"));
        Integer sex = Integer.valueOf(request.getParameter("sex"));
        Date birth = null;
        try {
            birth = sdf.parse(request.getParameter("birth"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.updateStudent(new Student(id,name,address,age,sex,birth));
        response.sendRedirect("queryAll.do");
    }
}
