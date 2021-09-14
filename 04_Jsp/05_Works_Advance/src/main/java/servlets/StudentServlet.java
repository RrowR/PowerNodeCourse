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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/Student.do")
public class StudentServlet extends HttpServlet {
    private StudentDao studentDao = new StudentDaoImpl();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;utf-8");
        response.setCharacterEncoding("utf-8");

        // 获取传过来的值
        String service = request.getParameter("service");
        // this指代的是调用者，这里的调用者是service 不是传过来的参数 (Student.do?service=queryAll)
        try {
            // 通过传过来的参数反射获得方法
            Method declaredMethod = this.getClass().getDeclaredMethod(service,HttpServletRequest.class,HttpServletResponse.class);
            /* Object invoke(Object obj, Object... args) 对带有指定参数的指定对象调用由此 Method 对象表示的底层方法。
                使用invoke来进行调用，反过来调用，先找到指定方法，然后传入这个方法的参数
                this指代的是对象 |  要调用方法，需要传入拥有这个方法的对象StudentServlet 再传入这个方法的其他参数
             */
            declaredMethod.invoke(this,request,response);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    // 查询所有
    private void queryAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getAttribute("failcode");
        List<Student> students = studentDao.queryAllStudent();
        req.getSession().setAttribute("students",students);
        resp.sendRedirect("list.jsp");
    }

    // 查询一个
    private void queryOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Student student = studentDao.queryStudentById(Integer.parseInt(id));
        req.setAttribute("student",student);
        req.getRequestDispatcher("upDate.jsp").forward(req,resp);
    }

    private void addOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        queryAll(request,response);
    }

    // 删除一个
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        new StudentDaoImpl().deleteStudent(Integer.parseInt(id));
        queryAll(request,response);
    }

    // 修改一个
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        queryAll(request,response);
    }


}
