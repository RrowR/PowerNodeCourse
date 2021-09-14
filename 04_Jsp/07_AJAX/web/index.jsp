<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="#" method="post">
    <p>用户名:<input type="text" name="username" id="username" onblur="checkUsername(this)">
      <span id="usernameSpan"></span>
    </p>
    <p>密码:<input type="text" name="password" id="password"></p>
    <button>注册</button>
  </form>
  </body>
  <script>
    var request = new XMLHttpRequest();
    function checkUsername(obj){
      // 获取输入框里的值
      let name = obj.value;
      //  建立连接
      request.open("GET","check.do?username="+name);
      request.onreadystatechange = stateChange;
      // 发送请求
      request.send();
    }

    // 回调方法
    function stateChange(){
      console.log("我执行了"+ request.status + " " + request.readyState);
      let span = document.getElementById("usernameSpan");
      if (request.status == 200 && request.readyState == 4){
        // 以字符串的形式响应后端返回的结果
        if (request.responseText == "true"){
          span.innerHTML = "<span style='color: green'>用户名可用</span>"
        }else{
          span.innerHTML = "<span style='color: red'>用户名不可用</span>"
        }
      }

    }
  </script>
</html>
