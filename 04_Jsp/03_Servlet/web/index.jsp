<%--
  Created by IntelliJ IDEA.
  User: Atlantis
  Date: 2021/8/28
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%
  pageContext.setAttribute("pageContextAttr","pageContextResult");
  request.setAttribute("requestAttr","requestResult");
  session.setAttribute("sessionAttr","sessionResult");
  application.setAttribute("applicationAttr","applicationResult");
%>
<%--dispacher--%>
<jsp:forward page="ELExpr.jsp"></jsp:forward>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index.jsp</title>
  </head>
  <body>
  </body>
</html>
