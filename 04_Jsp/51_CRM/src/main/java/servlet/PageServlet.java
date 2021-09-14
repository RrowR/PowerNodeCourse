package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跳转页面的Servlet
 */
@WebServlet("/page.do")
public class PageServlet extends BaseServlet{
    /**
     * 跳转到登陆成功的首页
     */
    private void main(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(PATH_PREFIX+"main.jsp").forward(request,response);
    }
}
