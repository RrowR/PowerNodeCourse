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
        // 这里其实最好使用内部转发，我只需要跳转到查修改的页面，上面地址变不变无所谓，因为用户也不是开发人员
        req.setAttribute("student",student);
        req.getRequestDispatcher("upDate.jsp").forward(req,resp);
    }
}
