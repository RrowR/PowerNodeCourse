<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
    引入jstl核心包 注意:在tomcat也要导包，这里我使用的是maven，和在WEB-INF/lib 下一模一样，但是在tomcat里看不见
    在out输出路径下的artifact里
 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL的初次使用</title>
</head>
<body>
    <%
        request.setAttribute("score",100);
    %>
    <%--  使用tomcat里自带的tomcat-el-api-8.5.38.jar里--%>
    ${ score > 80 ? '<span style="color: green">成绩优秀</span>' : '<span style="color: red">成绩差</span>'}
    <%--  使用JSTL表达式，外部引入的jstl-1.2.jar里  --%>
    <%--  JSTL存在的意义就是为了扩展EL功能上的不足，在使用JSTL的时候，里面照样可以写EL,好处是在JSTL里面可以写html代码了--%>
    <%--  注意:没有<c:else></c:else>  --%>
    <c:if test="${score>80}">
        <br>
        <span style="color: green">成绩优秀</span>
    </c:if>
    <c:if test="${score<=80}">
        <span style="color: red">成绩差</span>
    </c:if>
</body>
</html>
