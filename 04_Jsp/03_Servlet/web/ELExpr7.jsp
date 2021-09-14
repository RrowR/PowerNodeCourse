<%--
  Created by IntelliJ IDEA.
  User: Atlantis
  Date: 2021/8/29
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内置对象</title>
    <%--
        1	pageContext	对应于JSP页面中的pageContext对象（注意：取的是pageContext对象）
        2	pageScope	代表page域中用于保存属性的Map对象
        3	requestScope	代表request域中用于保存属性的Map对象
        4	sessionScope	代表session域中用于保存属性的Map对象
        5	applicationScope	代表application域中用于保存属性的Map对象
        6	param	表示一个保存了所有请求参数的Map对象
        7	paramValues	表示一个保存了所有请求参数的Map对象，它对于某个请求参数，返回的是一个string[]
        8	header	表示一个保存了所有http请求头字段的Map对象
        9	headerValues	同上，返回string[]数组。注意：如果头里面有“-” ，例Accept-Encoding，则要headerValues[“Accept-Encoding”]
        10	cookie	表示一个保存了所有cookie的Map对象
        11	initParam	表示一个保存了所有web应用初始化参数的map对象
    --%>
</head>
<body>
    <h1>取请求头</h1>
    <p>${header.get("accept")}</p>
    <p>${header.get("Accept-Encoding")}</p>
    <p>${header.get("Cookie")}</p>
    <p>${headerValues["Accept-Encoding"][0]}</p>
    <p>${headerValues["Accept-Encoding"][1]}</p>
    <p>${cookie.get("JSESSIONID").name}:${cookie.get("JSESSIONID").value}</p>
</body>
</html>
