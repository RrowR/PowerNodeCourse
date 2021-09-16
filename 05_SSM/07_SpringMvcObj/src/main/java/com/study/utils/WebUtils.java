package com.study.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WebUtils {
    public static HttpServletRequest getRequest(){
        /*
            RequestContextHolder 是org.springframework.web.context.request里的一个抽象类里面有抽象方法
            RequestContextHolder.currentRequestAttributes 是获得mvc容器里的对象的方法

            RequestContextHolder.currentRequestAttributes()
            它是Spring MVC框架内部工具，外界很少用到
            它的作用是Model在封装Request、Session的数据时
            是通过RequestContextHolder.currentRequestAttributes()
            取得当前线程下的Request、Session的Attribute值

            ServletRequestAttributes 是获取请求参数，在servlet中，请求的key就是程序的访问入口，value就是对应的类（也就是对应页面请求的servlet）
         */
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = ((ServletRequestAttributes) requestAttributes);
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return request;
    }

    public static HttpServletResponse getResponse(){
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = ((ServletRequestAttributes) requestAttributes);
        System.out.println(requestAttributes.getClass().getSimpleName());
        HttpServletResponse response = servletRequestAttributes.getResponse();
        return response;
    }

    public static HttpSession getSession(){
        return getRequest().getSession();
    }

    public static ServletContext getServletContext(){
        ServletContext servletContext = getRequest().getSession().getServletContext();
        return servletContext;
    }
}
