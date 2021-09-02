package servlet;



import common.Constant;
import common.Result;
import domain.User;
import service.IUserService;
import service.impl.UserServiceImpl;
import utils.RespUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆 控制器
 */
@WebServlet("/login.do")
public class LoginServlet extends BaseServlet{
    //创建IUserService的对象
    private IUserService userService=new UserServiceImpl();
    /**
     * 登陆
     * @param request
     * @param response
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到用户名和密码
        String username = request.getParameter("username");
        String password=request.getParameter("password");
        User user = userService.login(username, password);
        if(user!=null){
            //放到session
            request.getSession().setAttribute(Constant.SESSION_CURRENT_USER_KEY,user);
            //给用户响应登陆成功
            RespUtils.writer(new Result(200,"登陆成功"),response);
        }else{
            RespUtils.writer(new Result(-1,"用户名或密码不正确"),response);
        }
    }
}
