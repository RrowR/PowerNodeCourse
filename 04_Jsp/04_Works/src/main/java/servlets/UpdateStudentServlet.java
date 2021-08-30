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

@WebServlet("/UpdateStudent.do")
public class UpdateStudentServlet extends HttpServlet {
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            这里能获取到id，不管是用 location.href = "UpdateStudent.do?id=xxx" 还是 <a href = "UpdateStudent.do?id=xxx"><a/>
            只要带上id就行
        */
        String id = req.getParameter("id");
        Student student = studentDao.queryStudentById(Integer.parseInt(id));
        // 这里也是从list跳转过来的，只是这里是先调用了这个接口而已，所以最好还是重定向(会有地址变化)
        req.getSession().setAttribute("student",student);
        resp.sendRedirect("upDate.jsp");
    }
}
