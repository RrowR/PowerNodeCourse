<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<table align="center">
    <form action="user/getMap.do" method="get">
        <tr><td><input name="username" value="猫羽雫"></td></tr>
        <tr><td><input name="age" value="16"></td></tr>
        <tr><td><input name="address" value="pixiv"></td></tr>
        <tr><td><input type="submit" value="提交"></td></tr>
    </form>
</table>
<hr>
<table align="center">
    <form action="user/getArr.do" method="get">
        <div align="center">
            <input name="list" type="checkbox" value="cs1.6">cs1.6
            <input name="list" type="checkbox" value="cf">cf
            <input name="list" type="checkbox" value="dnf">dnf
            <input name="list" type="checkbox" value="csgo">csgo
            <tr><td><input type="submit" value="提交"></td></tr>
        </div>
    </form>
</table>

<table align="center">
    <form action="user/getArr2.do" method="get">
        <div align="center">
            <input name="List" type="checkbox" value="cs1.6">cs1.6
            <input name="List" type="checkbox" value="cf">cf
            <input name="List" type="checkbox" value="dnf">dnf
            <input name="List" type="checkbox" value="csgo">csgo
            <tr><td><input type="submit" value="提交"></td></tr>
        </div>
    </form>
</table>

</body>
</html>
