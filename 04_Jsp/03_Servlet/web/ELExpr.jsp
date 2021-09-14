<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<%--EL表达式的好处就是不用写java代码--%>
<body>
    <p><%=pageContext.getAttribute("pageContextAttr")%></p>
    <p><%=request.getAttribute("requestAttr")%></p>
    <p><%=session.getAttribute("sessionAttr")%></p>
    <p><%=application.getAttribute("applicationAttr")%></p>
</body>
<script>
    // EL表达式不需要导包

</script>
</html>
