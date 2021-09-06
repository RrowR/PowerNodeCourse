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
      /*
        JSON是一种较为理想的数据传输格式，它能够很好的融合与JavaScript或其他宿主语言，并且可以被JS直接使用。
        使用JSON相比传统的通过 GET、POST直接发送“裸体”数据，在结构上更为合理，也更为安全。
        至于jQuery的getJSON()函数，只是设置了JSON参数的 ajax()函数的一个简化版本。
        就是将预期的返回的数据类型设置为:JSON.语法为:


       */
      let param = {username:"username"};
      $("#btn4").on("click",function (){
        $.getJSON(
            "getJSON.do",       // 请求地址
            param,              // 请求参数
            function (res){     // rollback
              console.log(res);
            }
        );
      })


  </script>
</html>
