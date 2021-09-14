package utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 统一向客户端写JSON数据的类
 */
public class RespUtils {
    /**
     * 将数据使用JSON格式 返给客户端
     * @param rs
     * @param resp
     */
    public static  void writer(Object rs, HttpServletResponse resp) throws IOException {
        //设置数据格式
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        //将业务结果对象转化为字符串
        String result = JSON.toJSONString(rs);
        writer.write(result);
        writer.flush();
        writer.close();
    }
}
