<%--
  Created by IntelliJ IDEA.
  User: romantic
  Date: 2021/9/15
  Time: 12:09 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1 align="center">这是首页</h1>
    <table align="center">
      <form action="user/index.do" method="get">
          <tr><td><input name="username" value="猫羽雫"></td></tr>
          <tr><td><input name="age" value="16"></td></tr>
          <tr><td><input name="address" value="pisiv"></td></tr>
          <tr><td><input type="submit" value="提交"></td></tr>
      </form>
    </table>
  </body>
</html>
