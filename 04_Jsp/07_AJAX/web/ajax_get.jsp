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
    <input type="button" id="btn4" value="getJson">

    <div id="div1" style="border: red solid 2px;height: 200px"></div>
  </body>
  <script>
      /*
        这是一个简单的 GET 请求功能以取代复杂 $.ajax 。
        请求成功时可调用回调函数。如果需要在出错时执行函数，请使用 $.ajax。只支持异步的请求.都是使用$.ajax的默认属性值.$.get就是type为get
        $.get(url,[data],[callback],[type]) 替代


        $.ajax({
          url:"check.do", // 请求地址
          type:"get",     // 请求方式
          timeout:5000,   // 超时时间
          data:"username="+username,   // 可以这样直接拼，而且必须这样拼，也可以选择在url后面拼？
          dataType:"text",    // 希望返回数据类型
          contentType:"application/x-www-form-urlencoded",    // 默认值适合大多数应用场合
          beforeSend:function (){
            console.log("发送前");
          },
          success:function (res){
            console.log("请求成功"+res);
          },
          error:function (){
            console.log("请求失败...");
          },
          complete:function (){
            console.log("请求完成");
          }
        })

       */
      $("#btn2").on("click",function (){

        $.get("get.do",{username:"username"},function (res){
          console.log(res);
        });

      })
  </script>
</html>
