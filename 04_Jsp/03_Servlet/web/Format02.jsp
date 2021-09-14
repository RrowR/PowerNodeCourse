<%@ page import="java.util.Date" %>
<%@ page import="com.domain.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>日期格式化</title>
</head>
<body>
    <%
        request.setAttribute("date",new Date());
        request.setAttribute("user",new Student("猫羽雫",16,new Date()));
    %>
    <%-- 这里才需要有var --%>
    <fmt:formatDate value="${date}" var="fmtDate" pattern="yyyy-MM-dd"></fmt:formatDate>
    ${fmtDate}<br>
    <fmt:formatDate value="${user.birth}" var="user_birth" pattern="yyyy/MM/dd"></fmt:formatDate>
    ${user_birth}
</body>
</html>
