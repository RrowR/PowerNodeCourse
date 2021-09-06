<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>jquery的省略和其他使用方法</title>
  </head>
  <script src="resources/jquery/jquery-3.6.0.min.js"></script>
  <body>
    <input type="button" id="btn1" value="按钮1">
    <input type="button" id="btn2" value="按钮2">
    <input type="button" id="btn3" value="按钮3">
    <input type="button" id="btn4" value="按钮4">

    <div id="div1" style="border: red solid 2px;height: 200px"></div>
  </body>
  <script>
      $("#btn1").click(function (){
          /*
            $(selector).load(URL,data,callback);
            url: URL地址
            data:待发送参数。
            callback:载入成功时回调函数。
           */
          // 将ajax请求的结果放到id=div1中
          $("#div1").load("check.do",{"username":"username"},function (){})
      })
  </script>
</html>
