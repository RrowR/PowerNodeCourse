<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Student" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Atlantis
  Date: 2021/8/26
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户到表中</title>
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
            <td>爱好</td>
            <td>生日</td>
        </tr>
    <%
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(new Student("User"+i,22+i,"hobby"+i,new Date()));
        }
        for (int i = 0; i < students.size(); i++) {
            out.write("<tr align = 'center'>");
            out.write("<td>"+ students.get(i).getName() +"</td>");
            out.write("<td>"+ students.get(i).getAge() +"</td>");
            out.write("<td>"+ students.get(i).getHobby() +"</td>");
            out.write("<td>"+ students.get(i).getBirth() +"</td>");
            out.write("</tr>");
        }
    %>
    </table>
</body>
</html>
