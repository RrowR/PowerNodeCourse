<%@ page import="com.domain.Student" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Atlantis
  Date: 2021/8/29
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式取对象里的值</title>
</head>
<body>
    <%--  使用原生jsp来存值  --%>
    <%
        request.setAttribute("user",new Student("猫羽雫",16,new Date()));
        request.setAttribute("b",true);
    %>
    <%-- 使用EL来取值   --%>
    <%--
        这里还有一个问题，我对象的属性是私有的，但是还能直接获取对象的属性，看来是默认帮我们调用了get方法
        如果没有get方法，那么这个对象.属性是点不出来的,服务器还会报500的错误
   --%>
    ${user.name}<br/>
    ${user.age}<br/>
    <%-- 国际化时间   --%>
    ${user.birth}<br/>
    <%--  当前系统格式时间  --%>
    ${user.birth.toLocaleString()}<br/>
    ${b};<br>

</body>
</html>
