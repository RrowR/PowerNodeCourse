<%@ page import="dao.StudentDao" %>
<%@ page import="impl.StudentDaoImpl" %>
<%@ page import="entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: romantic
  Date: 2021/8/28
  Time: 2:20 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp"%>
<html>
<head>
    <title>人员修改</title>
</head>
<body>
<%
    StudentDao studentDao = new StudentDaoImpl();
    String id = request.getParameter("id");
    Student student = studentDao.queryStudentById(Integer.parseInt(id));
%>
<form action="upDateServer.jsp" method="get">
    <input type="hidden" name="id" value="<%=student.getId()%>">
    <table border="1" width="50%" align="center" cellpadding="1" cellspacing="0">
        <tr>
            <td>姓名</td>
            <%--这里需要带上 = 号 --%>
            <td><input type="text" name="name" value="<%=student.getName()%>" /></td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="address" value="<%=student.getAddress()%>"/></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age" value="<%=student.getAge()%>" /></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <%
                    if (student.getSex()==1){
                        out.write(
                                "<input type='radio' name='sex' value='1' checked/>男"+
                                "<input type='radio' name='sex' value='0'/>女");
                    }else {
                        out.write(
                                "<input type='radio' name='sex' value='1'/>男"+
                                "<input type='radio' name='sex' value='0' checked/>女");
                    }
                %>
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td>
                <input type="date" name="birth" value="<%=student.getBirth()%>"/>
                <span>请重新选择生日</span>
            </td>
        </tr>
        <tr>
            <th colspan="2">
                <button type="submit">提交</button>
                <button type="button" onclick="back()">返回</button>
            </th>
        </tr>
    </table>
</form>
<script>
    function back(){
        location.href = "xxx.jsp";
    }
</script>
</body>
</html>
