<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单管理</title>
</head>
<%-- 这个frameset是没有提示的 --%>
<frameset cols="200,*" frameborder="yes" border="2">
    <frame src="${ctx}/page/toLeftMenuManager.action" name="left">
    <frame src="${ctx}/page/toRightMenuManager.action" name="right">
</frameset>
</html>
