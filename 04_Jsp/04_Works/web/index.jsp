<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="impl.StudentDaoImpl" %>
<%@ page import="dao.StudentDao" %>
<%@ page import="entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: Atlantis
  Date: 2021/8/27
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp" %>
<html>
<head>
    <title>人员管理系统</title>
</head>
<body>
<h1 align="center">人员管理系统</h1>
<hr>
<table border="1" width="80%" cellpadding="0" cellspacing="0" align="center">
    <tr>
        <td colspan="11">
            <a href="add.jsp">添加学生</a>
        </td>
    </tr>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>姓别</th>
        <th>地址</th>
        <th>年龄</th>
        <th>生日</th>
        <th>操作</th>
    </tr>
<%--    <c:forEach items="${students}" var="stu">--%>
<%--        --%>
<%--    </c:forEach>--%>
    <%
        String[] students = request.getParameterValues("students");
        System.out.println(Arrays.toString(students));
    %>

</table>
<script>
    function update(id){
        location.href = "upDate.jsp?id="+id+"";
    }

    function del(id){
        location.href = "delServer.jsp?id="+id+"";
    }
</script>
</body>
</html>
