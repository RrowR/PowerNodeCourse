<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Atlantis
  Date: 2021/8/29
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>EL表达式获取集合的方法</title>
  </head>
  <body>
      <%
          // 数组转成链表
          List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
          request.setAttribute("nums",integers);
      %>
        <%--可以直接调用nums链表里的size方法--%>
        <p>${nums.size()}</p>
  </body>
</html>
