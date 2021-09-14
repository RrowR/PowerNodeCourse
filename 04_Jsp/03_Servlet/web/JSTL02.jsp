<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Atlantis
  Date: 2021/8/29
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>choose...when...多条件分支标签</title>
</head>
<body>
    <%
        request.setAttribute("num",20);
    %>

    <c:choose>
        <%-- test="" 里面是条件 --%>
        <c:when test="${num > 80}">
            大于80
        </c:when>
        <c:when test="${num > 70}">
            70~80
        </c:when>
        <c:when test="${num > 60}">
            60~70
        </c:when>
        <c:otherwise>
            小于60
        </c:otherwise>
    </c:choose>

</body>
</html>
