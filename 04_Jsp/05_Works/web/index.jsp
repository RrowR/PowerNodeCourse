<%@ page import="impl.StudentDaoImpl" %>
<%@ page import="dao.StudentDao" %>
<%@ page import="entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <c:forEach items="${students}" var="student">
        <tr>
            <th>${student.id}</th>
            <th>${student.name}</th>
            <th>${student.address}</th>
            <th>${student.age}</th>
            <th>${student.age}</th>
            <th>${student.sex}</th>
            <th>${student.id}</th>
        </tr>
    </c:forEach>

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
