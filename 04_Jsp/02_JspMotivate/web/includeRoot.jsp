<%--
  Created by IntelliJ IDEA.
  User: Atlantis
  Date: 2021/8/27
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>要使用引入的页面的页面</title>
</head>
<%--
    引入一个page 指令 页面，目的是为了获得别的页面里的值（java类型）
    注意：这里的引入要加上一个@
--%>
<%-- page指令 --%>
<%@ include file="included.jsp"%>
<%--<jsp:include page="included.jsp">--%>
<%
    int b = a;
    // 注意这个方法有重载，会根据ASCII编码来转换
    // 我这里就使用字符串吧
    out.write(b);
    out.write("<br>");
    out.write(b+"");
%>
<body>
</body>
</html>
