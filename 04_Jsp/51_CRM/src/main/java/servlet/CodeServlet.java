package servlet;

import cn.hutool.captcha.LineCaptcha;
import common.Constant;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/capcha.do")
public class CodeServlet extends BaseServlet {
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LineCaptcha lineCaptcha = new LineCaptcha(100, 40,1,2);
        // 获得验证码串
        String code = lineCaptcha.getCode();
        // 把验证码放到session中
        request.getSession().setAttribute(Constant.SESSION_CODE_KEY,code);
        // 这里是需要获得response的输出流把lineCaptcha输出出去
        ServletOutputStream servletOutputStream = response.getOutputStream();
        lineCaptcha.write(servletOutputStream);
    }
}
