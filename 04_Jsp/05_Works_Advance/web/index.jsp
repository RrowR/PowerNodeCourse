<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<style>
</style>
<body>
    <form action="login.do" method="post">
        <table align="center" cellpadding="0" cellspacing="0" border="1">
            <tr>
                <th>账户:</th>
                <th><input type="text" name="username" placeholder="请输入账户"></th>
            </tr>
            <tr>
                <th>密码:</th>
                <th><input type="password" name="password" placeholder="请输入密码"></th>
            </tr>
            <tr>
                <th><img src="captcha.do" width="86" height="21" onclick="this.src=this.src+'?'"></th>
                <th><input type="text" name="code"></th>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="登陆"><span style="color: red">${failcode}</span></td>
            </tr>
        </table>
    </form>
</body>
</html>
