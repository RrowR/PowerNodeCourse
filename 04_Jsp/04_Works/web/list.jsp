<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <th>
            <c:if test="${student.sex == 1}">
                男
            </c:if>
            <c:if test="${student.sex == 0}">
                女
            </c:if>
        </th>
        <th>${student.address}</th>
        <th>${student.age}</th>
        <th><fmt:formatDate value="${student.birth}" pattern="yyyy-MM-dd"></fmt:formatDate></th>
        <th><input type='button' onclick='update()' value='修改' /> &nbsp <input type='button' onclick='del("+${student.id}+")' name='del' value='删除'></th>
    </tr>
</c:forEach>

</table>
<script>
    function update(){
        <%--location.href = "UpdateStudent.do?id=+${student.id}";--%>
        alert("update点击了")
    }

    function del(){
        location.href = "delServer.jsp?id="+${student.id};
    }
</script>
</body>
</html>
