<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
      <div align="right" style="height: 20px">
       按职位:<input type="text" id="input"> <input type="button" value="查询" id="search">
      </div>
    <hr>
    <div align="right"><a href="#">发布招聘信息</a></div>
    <table border="1px soild black" align="center" cellspacing="0">
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
    console.log($("#input").val());
    $.ajax({
      url:"companyPosition.do?service=queryAll&"+$("#input").val(),
      type:"get",
      dataType:"json",
      success:function (res){
        console.log(res)
        renderTable(res);
      }
    })
  })

  function renderTable(data){

  }
</script>
</html>
