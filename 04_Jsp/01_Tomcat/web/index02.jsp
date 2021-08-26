<%--
  Created by IntelliJ IDEA.
  User: Atlantis
  Date: 2021/8/26
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>九九乘法表</title>
</head>
<body>
    <%
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                out.write(i + "*" + j + "=" + (i*j));
            }
            out.write("<br>");
        }
    %>
</body>
</html>
