<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>jquery的省略和其他使用方法</title>
  </head>
  <script src="resources/jquery/jquery-3.6.0.min.js"></script>
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
          data:{"username":username},   // 也直接使用json的格式
          dataType:"text",    // 希望返回数据类型，其实也可以省略
          contentType:"application/json",    // 告诉服务器给过去的数据是什么格式，上面的data是json，所以要告诉是json，其实也是可以省略的
          success:function (res){     // 服务器响应回来的数据
            console.log("请求成功"+res);
          },
          error:function (){
            console.log("请求失败...");
          },
        })
      })
  </script>
</html>
