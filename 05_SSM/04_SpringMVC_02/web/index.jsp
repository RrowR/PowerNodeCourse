<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index.jsp</title>
  </head>
  <body>
    <h1 align="center">这是首页</h1>
    <table align="center">
      <form action="user/index.do" method="get">
          <tr><td><input name="UserName" value="猫羽雫"></td></tr>
          <tr><td><input name="Age" value="16"></td></tr>
          <tr><td><input name="Address" value="pisiv"></td></tr>
          <tr><td><input type="submit" value="提交"></td></tr>
      </form>
    </table>

    <table align="center">
        <form action="user/domain.do" method="get">
            <tr><td><input name="username" value="猫羽雫"></td></tr>
            <tr><td><input name="age" value="16"></td></tr>
            <tr><td><input name="address" value="pixiv"></td></tr>
            <tr><td><input type="submit" value="提交"></td></tr>
        </form>
    </table>
  </body>
</html>
