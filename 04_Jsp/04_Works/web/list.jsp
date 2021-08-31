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
        <%--这里的每个id都不一样，所以一定要传值--%>
        <th><input type="button" onclick="update(${student.id})" value="修改" /><input type="button"  onclick="del(${student.id})" value="删除" /></th>
    </tr>
</c:forEach>

</table>

</body>
<script>
    function update(id){
        location.href = "UpdateStudent.do?id="+id;
    }

    function del(id){
        location.href = "delServer.jsp?id="+id;
    }
</script>
</html>
