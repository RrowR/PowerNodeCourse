package servlet;

import cn.hutool.captcha.LineCaptcha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/capcha.do")
public class CodeServlet extends BaseServlet{
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LineCaptcha lineCaptcha = new LineCaptcha(100, 40,1,2);
        // 获得验证码串
        String code = lineCaptcha.getCode();
        // 把验证码放到session中
        request.getSession().setAttribute("code",code);
        

    }
}
