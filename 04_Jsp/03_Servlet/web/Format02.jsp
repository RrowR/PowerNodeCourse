<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>日期格式化</title>
</head>
<body>
    <%
        request.setAttribute("date",new Date());
    %>
    <%-- 这里才需要有var --%>
    <fmt:formatDate value="${date}" var="fmtDate" pattern="yyyy-MM-dd"></fmt:formatDate>
    ${fmtDate}
</body>
</html>
