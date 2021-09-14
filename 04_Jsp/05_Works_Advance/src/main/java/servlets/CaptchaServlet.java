package servlets;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * hutools生成条形验证码,只要有方法来调用这个接口，就可以返回出验证码，hutools也支持stream
 */
@WebServlet("/captcha.do")
public class CaptchaServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(85, 20,4,2);
        // 先获取图片的验证码内容，lineCaptcha.getCode(),然后放入request里的session域中
        req.getSession().setAttribute("code",lineCaptcha.getCode());
        // 得到字节输出流(此时这里是服务器，来接收请求，index是客户端，我们要获得response来获得输出流来相应index.jsp)
        ServletOutputStream outputStream = resp.getOutputStream();
        // 把验证码的流写出去
        lineCaptcha.write(outputStream);
    }
}
