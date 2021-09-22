package com.study.system.utils;

import com.study.system.common.Constants;
import com.study.system.domain.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WebUtils {
    /**
     * 提供一个可以得到当前线程的请求对象的方法
     * @return
     */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        System.out.println(requestAttributes.getClass().getSimpleName());
        System.out.println(requestAttributes.getRequest());
        return requestAttributes.getRequest();
    }

    /**
     * 提供一个可以得到当前线程的响应对象的方法
     * @return
     */
    public static HttpServletResponse getResponse(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return requestAttributes.getResponse();
    }

    /**
     * 提供一个可以得到当前线程的session的方法
     * @return
     */
    public static HttpSession getSession(){
        return getRequest().getSession();
    }
    /**
     *  获取全局容器对象
     * @return
     */
    public static ServletContext getContext(){
        //getRequest().getServletContext(); // ServletContext 的生命周期 是早于 HttpServletRequest
        //所以不能通过 HttpServletRequest 获取ServletContext  可能发生 NullpointException
//        return  ContextLoader.getCurrentWebApplicationContext().getServletContext();
        return getRequest().getSession().getServletContext();
    }

    /*
        得到当前用户对象
     */
    public static User getCurrentUser(){
        User user = (User) getSession().getAttribute(Constants.CURRENT_SESSION_USER_KEY);
        return user;
    }

    /*
        得到当前对象的真实名字
     */
    public static String getCurrentUserName(){
        User user = (User) getSession().getAttribute(Constants.CURRENT_SESSION_USER_KEY);
        return user.getRealname();
    }
}
