<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>jquery的省略和其他使用方法</title>
  </head>
  <script src="resources/jquery/jquery-3.6.0.min.js"></script>
  <body>
    <input type="button" id="btn1" value="load">
    <input type="button" id="btn2" value="get">
    <input type="button" id="btn3" value="post">
    <input type="button" id="btn4" value="getJSON">

    <div id="div1" style="border: red solid 2px;height: 200px"></div>
  </body>
  <script>
      $("#btn3").on("click",function (){
        $.post("post.do",{username:"username"},function (res){
          console.log(res);
        });
      })


  </script>
</html>
