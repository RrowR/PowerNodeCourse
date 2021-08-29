<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   <%--第一步，引入格式化标签--%>
<html>
<head>
    <title>数字格式化</title>
</head>
<body>
    <%
        request.setAttribute("sal",1231321.321421421);
    %>
    <%--  注意:日期格式化不能使用var  --%>
    <fmt:formatNumber value="${sal}" pattern="###,###,###.##" type="Number"></fmt:formatNumber><br>
    <%
        request.setAttribute("sal2",91231312.12912);
    %>
    <fmt:formatNumber value="${sal2}" pattern="#.##"></fmt:formatNumber><br>
</body>
<script>
</script>
</html>
