<%--
  Created by IntelliJ IDEA.
  User: NINGMEI
  Date: 2021/9/2
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加职位</title>
</head>
<body>
<h1 align="center">发布职位招聘信息</h1>
<hr>
<div>
    <form action="job.do?service=add" method="post">
    <table align="center" border="1" width="30%">
        <tr>
            <td align="right">职位名称:</td>
            <td>
                <input type="text" name="pname">
            </td>
        </tr>
        <tr>
            <td align="right">最低薪水:</td>
            <td>
                <input type="number" name="minsal">
            </td>
        </tr>
        <tr>
            <td align="right">最高薪水:</td>
            <td>
                <input type="number" name="maxsal">
            </td>
        </tr>
        <tr>
            <td align="right">发布公司:</td>
            <td>
                <select name="cid">
                    <c:forEach items="${companyList}" var="sn">
                        <option value="${sn.cid}">${sn.cname}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="发布">
            </td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>
