<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>欢迎来到招聘系统</title>
  </head>
  <script src="webjars"></script>
  <style>
  </style>
  <body>
    <h1 align="center">招聘系统企业版</h1>
    <hr>
      <div align="right" style="height: 20px">
       按职位:<input type="text" id="search"> <input type="button" value="查询">
      </div>
    <hr>
    <div align="right"><a href="#">发布招聘信息</a></div>
    <table>
      <tr>
        <td>职位名称</td>
        <td>公司名称</td>
        <td>职位月薪</td>
        <td>工作地点</td>
        <td>发布日期</td>
        <td>操作</td>
      </tr>

    </table>
  </body>
<script>
  $("#search").click(function (){
    location.href = "";
  });
</script>
</html>
