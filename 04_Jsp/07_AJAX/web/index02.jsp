<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
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
        let value = this.value;
        $.ajax({
          url:"check.do",
          type:"get",
          data:value,   // 也可以选择在url后面拼？
          dataType:text,    // 希望返回数据类型
          contentType:"application/x-www-form-urlencoded",    // 默认值适合大多数应用场合
          beforeSend:function (){
            console.log("发送前");
          },
          success:function (res){
            console.log(res);
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
