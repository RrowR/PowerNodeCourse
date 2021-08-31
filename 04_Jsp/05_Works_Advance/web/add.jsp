<%--
  Created by IntelliJ IDEA.
  User: romantic
  Date: 2021/8/27
  Time: 11:41 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
    <form action="Student.do?service=addOne" method="post">
        <table border="1" width="50%" align="center" cellpadding="1" cellspacing="0">
            <tr>
                <td>姓名</td>
                <td><input type="text" name="name" placeholder="请输入姓名" /></td>
            </tr>
            <tr>
                <td>地址</td>
                <td><input type="text" name="address" placeholder="请输入地址" /></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="text" name="age" placeholder="请输入年龄" /></td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                <input type="radio" name="sex" value="1"/>男
                <input type="radio" name="sex" value="0"/>女
                </td>
            </tr>
            <tr>
                <td>生日</td>
                <td>
                    <input type="date" name="birth"/>
                    <span>请选择生日</span>
                </td>
            </tr>
            <tr>
                <th colspan="2">
                <button type="submit">提交</button>
                <button type="reset">重置</button>
                </th>
            </tr>
        </table>
    </form>
</body>
</html>
