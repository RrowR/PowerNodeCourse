<%@ page import="com.domain.Student" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Atlantis
  Date: 2021/8/29
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ELExpr</title>
</head>
<body>
    <%
        request.setAttribute("nya",new Student("猫羽雫",16,new Date()));
    %>

    <%--
        使用EL表达式直接调用对象里的方法
            这样是可以的，但是没有提示
    --%>
    ${nya.getName()}
    <%--刚刚看到EL表达式确实可以取值，那么我们能设置值吗--%>
    ${nya.setName("美美")}    <%-- 看到也是可以的 --%>
    ${nya.name}
</body>
</html>
