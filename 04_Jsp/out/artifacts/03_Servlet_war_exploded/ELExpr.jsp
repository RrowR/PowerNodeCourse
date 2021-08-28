<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>

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
