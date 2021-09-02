package servlet;



import common.Result;
import utils.RespUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 提取所有Servlet的公共部分
 */
public class BaseServlet extends HttpServlet {
    public static final String PATH_PREFIX="WEB-INF/views/";
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到service
        String service = request.getParameter("service");
        try {
            Method method = this.getClass().getDeclaredMethod(service,HttpServletRequest.class,HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this,request,response);
        }catch (Exception e){
            e.printStackTrace();
            RespUtils.writer(new Result(-1,"service操作参数不存在"),response);
        }
    }
}
