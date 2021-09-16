package com.study.controller;

import com.study.service.UserService;
import com.study.utils.MyWebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 *  SpringMVC获得Servlet相关对象
 */
@Controller
@RequestMapping("user")
public class ServletController {

    // 内部使用的是Thread Local来解决线程安全的问题
    @Resource
    private HttpServletRequest request;

    @RequestMapping("obj1.do")
    public String obj1(HttpServletRequest req){
        /*
            上面的2个HttpServletRequest是不同的对象，但是里   面的值是一样的，相当于是另一个副本
            其实内部是在从tomcat8开始，tomcat其实有一个池子，从最近使用的里面去拿
            而且jdbc这个池子的默认个数是10个
         */
        request.setAttribute("username","猫羽雫");
        System.out.println(req.getAttribute("username"));
        System.out.println(request.hashCode());
        System.out.println("req = " + req.hashCode());
        System.out.println(Thread.currentThread());
        return null;
    }

    @RequestMapping("obj2.do")
    public String obj2(HttpServletRequest req){
        /*
            这里请求过来的req和tomcat里上面的请求的req虽然是同一个对象，但是值已经是被清空了的
            此时req已经不存在线程安全的问题
         */
        System.out.println("req = " + req.hashCode());
        System.out.println(req.getAttribute("username"));
        return null;
    }

    @Resource
    private UserService userService;        // 从IOC容器里拿UserService

    @RequestMapping("obj3.do")
    public void obj3(){
        /*
            使用Service层的方法来获得HttpServletRequest对象，其实和第二个没什么区别，都是在容器里，只是中间套了一层而已

            这个方法并不是从形参传过来的，而是从自己的Service里传过来的，只不过这个ServiceImpl也要添加到IOC里面去

            Tomcat中的HttpServletRequest
            原理：
                在Tomcat启动时，我们访问Controller地址时,mvc的核心控制器 DispatcherServlet 会找 service ，
                service在父类的 FrameworkServlet 中，里面其实就很复杂了....
                总的来说，就是tomcat帮我们处理，当一个线程进来的时候，会自动创建一个request...等等其他，
                然后当同一个线程来访问的时候，request可能不同，但是里面的内容一定是相同的，不用担心线程安全的问题，
                不管我是从别的地方get装配的还是自己从参数接收过来的都不会影响数据安全的问题
                而且这个request都是从mvc里的DispatcherServlet来给我们进行操作的，所以我们可以直接装配HttpServletRequest
         */
        HttpServletRequest req = (HttpServletRequest) userService.getReq();
        req.setAttribute("name","猫羽雫");
        System.out.println("request.getAttribute(\"name\") = " + request.getAttribute("name"));
    }

    @Resource
    private MyWebUtils myWebUtils;

    @RequestMapping("obj4.do")
    public void obj4(){
        /*
            这里MyWebUtils必须添加到Spring容器，才可以获得DI注入的request对象，至于为什么稍后有其他案例
         */
        System.out.println(myWebUtils.getRequest());
    }




}
