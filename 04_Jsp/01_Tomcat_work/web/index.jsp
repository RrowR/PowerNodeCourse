<%@ page import="entity.Student" %>
<%@ page import="dao.StudentDao" %>
<%@ page import="impl.StudentDaoImpl" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: Atlantis
  Date: 2021/8/26
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    cellpadding是指单元格内文字与边框的距离;
    cellspacing边缘线的大小
--%>
<table border="1px" width="100%" cellpadding="0" cellspacing="0">
    <tr align="center">
        <td>用户名</td>
        <td>年龄</td>
        <td>id</td>
        <td>地址</td>
        <td>生日</td>
    </tr>
    <%
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.queryAllStudent();
        for (int i = 0; i < students.size(); i++) {
            out.write("<tr align = 'center'>");
            out.write("<td>"+ students.get(i).getName() +"</td>");
            out.write("<td>"+ students.get(i).getAge() +"</td>");
            out.write("<td>"+ students.get(i).getId() +"</td>");
            out.write("<td>"+ students.get(i).getAddress() +"</td>");
            out.write("<td>"+ students.get(i).getBirth() +"</td>");
            out.write("</tr>");
        }
    %>
</table>
</body>
</html>
