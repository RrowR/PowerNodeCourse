<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>人员修改</title>
</head>
<body>
    <input type="hidden" name="id" value="${student.id}">
    <table border="1" width="50%" align="center" cellpadding="1" cellspacing="0">
        <tr>
            <td>姓名</td>
            <%--这里需要带上 = 号 --%>
            <td><input type="text" name="name" value="${student.name}" /></td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="address" value="${student.address}"/></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age" value="${student.age}" /></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <c:if test="${student.sex == 1}">
                    <input type='radio' name='sex' value='1' checked/>男
                    <input type='radio' name='sex' value='0'/>女
                </c:if>
                <c:if test="${student.sex == 0}">
                    <input type='radio' name='sex' value='1' />男
                    <input type='radio' name='sex' value='0' checked/>女
                </c:if>
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td>
                <input type="date" name="birth" value="${student.birth}"/>
                <span>请重新选择生日</span>
            </td>
        </tr>
        <tr>
            <th colspan="2">
                <button type="submit" onclick="toSubmit()">提交</button>
                <button type="button" onclick="back()">返回</button>
            </th>
        </tr>
    </table>
<script>
    function toSubmit(){
        alert("提交了");
    }

    function back(){
        // location.href = "list.jsp";
        alert("点击了返回");
    }
</script>
</body>
</html>
