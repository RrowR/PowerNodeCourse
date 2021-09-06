<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <script src="js/jquery-3.6.0.min.js"></script>
  <body>
  <form action="#" method="post">
    <p>用户名:<input type="text" name="username" id="username">
      <span id="usernameSpan"></span>
    </p>
    <p>密码:<input type="text" name="password" id="password"></p>
    <button>注册</button>
  </form>
  </body>
  <script>
      $("#username").on("blur",function (){
        // 获取当前这个元素对象的value值
        let username = this.value;
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
      })
  </script>
</html>
