<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>欢迎来到招聘系统</title>
  </head>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <style>
  </style>
  <body>
    <h1 align="center">招聘系统企业版</h1>
    <hr>
        <div align="right" style="width: 80%">
          按职位:<input type="text" id="input"> <input type="button" value="查询" id="search">
        </div>
    <hr>
    <div align="right" style="width: 80%"><a href="job.do?service=toAdd">发布招聘信息</a></div>
    <table border="1px soild black" align="center" cellspacing="0" id="table">
      <tr>
        <td>职位名称</td>
        <td>公司名称</td>
        <td>职位月薪</td>
        <td>工作地点</td>
        <td>发布日期</td>
        <td>操作</td>
      </tr>
      <c:forEach items="${positions}" var="pt">
        <tr align="center">
          <td>${pt.pname}</td>
          <td>${pt.cname}</td>
          <td>${pt.minsal}~${pt.maxsal}</td>
          <td>${pt.loc}</td>
          <td>
            <fmt:formatDate value="${pt.releasedate}" pattern="yyyy-MM-dd"></fmt:formatDate>
          </td>
          <td>
            <a href="#" onclick="del(${pt.pid})">删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>

  </body>
<script>
  $("#search").click(function (){
    location.href = "job.do?service=query&input="+$("#input").val();
  })

  function del(pid){
    let flag=confirm("你确定要删除这条数据吗");
    if(flag){
      window.location.href = "job.do?service=delete&input="+pid;
    }
  }
</script>
</html>
