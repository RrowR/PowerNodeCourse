package servlet;

import dao.CompanyDao;
import dao.PositionDao;
import dao.impl.CompanyDaoImpl;
import dao.impl.PositionDaoImpl;
import entity.Position;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/job.do")
public class JobSystemServlet extends HttpServlet {
    private PositionDao positionDao = new PositionDaoImpl();
    private CompanyDao companyDao = new CompanyDaoImpl();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String service=req.getParameter("service");
        try{
            //得到当前类的Class对象
            Class cls = this.getClass();
            //根据方法名找到cls里面的方法对象
            Method method = cls.getDeclaredMethod(service, HttpServletRequest.class, HttpServletResponse.class);
            //调用方法
            method.invoke(this,req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String input = req.getParameter("input");
        List<Position> positions = positionDao.queryAllPosition(input);
        req.setAttribute("positions",positions);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String input = req.getParameter("input");
        int i = positionDao.deletePosition(Integer.valueOf(input));
        System.out.println("删除成功..." + i);
        query(req,resp);
    }

    /**
     * 去添加
     */
    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询 所有公司列表并放到req
        req.setAttribute("companyList",this.companyDao.queryAllCompany());
        //转发到list.jsp
        req.getRequestDispatcher("add.jsp").forward(req,resp);
    }

    /**
     * 添加
     */
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pname=req.getParameter("pname");
        Double minsal=Double.valueOf(req.getParameter("minsal"));
        Double maxsal=Double.valueOf(req.getParameter("maxsal"));
        Integer cid=Integer.valueOf(req.getParameter("cid"));
        //组装Position
        Position position=new Position(pname,minsal,maxsal,new Date(),cid);
        //保存
        this.positionDao.addPosition(position);
        //全查询
        this.query(req,resp);
    }


}
