package controller;

import dao.TcompanyPositionDao;
import dao.impl.TcompanyPositionDaoImpl;
import entity.TcompanyPosition;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/companyPosition.do")
public class SearchAllServlet extends HttpServlet {
    TcompanyPositionDao tcpDao = new TcompanyPositionDaoImpl();

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

    private void queryAll(HttpServletRequest req, HttpServletResponse resp){
        List<TcompanyPosition> tcompanyPositions = tcpDao.queryAll();

    }
}
