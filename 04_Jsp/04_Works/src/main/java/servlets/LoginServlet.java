package servlets;

import dao.UserDao;
import entity.User;
import impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    UserDao userDao = new UserDaoImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取在 CaptchaServlet 里存在session里的验证码
        String code = req.getSession().getAttribute("code").toString();
        // 在request域里获取username
        String username = req.getParameter("username");
        // 在request域里过去password
        String password = req.getParameter("password");
        String realCode = req.getParameter("code");
        /*System.out.println(code);
        System.out.println(username);
        System.out.println(password);
        System.out.println(realCode);*/
        // 从数据库里取查账户密码(实体字段一定要于数据库一致，否则BaseDao底层逻辑不对，参数可以不传满，对象属性一定要填满)
        User user = userDao.login(username, password);
        System.out.println(user);
        if (realCode.equalsIgnoreCase(code)){
            req.getRequestDispatcher("queryAll.do").forward(req,resp);
        }else {
            req.getSession().setAttribute("failcode","登陆失败");
            resp.sendRedirect("index.jsp");
        }
    }
}
