<%--
  Created by IntelliJ IDEA.
  User: Atlantis
  Date: 2021/8/29
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>关系运算符</title>
</head>
<body>
    <%--
        算术运算符 EL表达式不仅支持从作用域中获取数据，EL表达式也支持一些简单的运算符。 + - * / %
    --%>
    <%
        int m = 10;
        int n = 3;
        request.setAttribute("m",m);
        request.setAttribute("n",n);
    %>
    <p>${m+n}</p>
    <p>${m-n}</p>
    <p>${m*n}</p>
    <p>${m/n}</p>   <%--这里不会出现数据溢出问题--%>
    <p>${m%n}</p>
    <%--  关系运算符 来判断两个对象之间的关系(eq gt lt ...etc) 当然也不需要写java代码  --%>
    <p>${m eq n}</p>
    <p>${m gt n}</p>
    <%--  EL表达式也支持逻辑运算符  --%>
    <p>${m > 20 && n > 5}</p>
    <p>${m > 20 || n < 5}</p>
    <p>${m != 20 && n != 1}</p>
    <%-- EL表达式也支持三元运算符 --%>
    <p>${m < n ? m : n}</p>

    <%--
        EL表达式的empty方法(判断是否为空)
        empty运算符，表示数据为空。
        如果数据是字符串，那么字符串为null 或者空字符串则empty返回true
        如果数据是数组，那么数组为null或者空数组empty返回true
     --%>
    <p>${empty m}</p>
</body>
</html>
