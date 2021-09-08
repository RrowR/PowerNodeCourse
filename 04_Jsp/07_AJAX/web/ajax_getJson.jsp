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
    <input type="button" id="btn5" value="getJSONArray">

      <table id="StudentTable" border="1px solid" cellspacing="2px" cellpadding="2px" align="center" width="100%" >

      </table>
  </body>
  <script>
      /*
        JSON是一种较为理想的数据传输格式，它能够很好的融合与JavaScript或其他宿主语言，并且可以被JS直接使用。
        使用JSON相比传统的通过 GET、POST直接发送“裸体”数据，在结构上更为合理，也更为安全。
        至于jQuery的getJSON()函数，只是设置了JSON参数的 ajax()函数的一个简化版本。
        就是将预期的返回的数据类型设置为:JSON.语法为:
       */
      $("#btn4").click(function (){
        $.getJSON("queryOneStudent.do",function (res){
          console.log(res);     // res里返回的是一个json对象
          console.log(res.name);  // 可以直接获得json里的值
          console.log(res.age);
        })
      })

      // 获得一个json数组,这种是更简便的写法
      $("#btn5").click(function (){
        $.getJSON("students.do",function (res){
          renderTable(res);
        })
      })

      function renderTable(data){
        // 使用jquery找到这个table,别忘记带#
        let studentTable = $("#StudentTable");
        let html = "<tr> <th>ID</th> <th>姓名</th> <th>年龄</th> <th>性别</th> <th>地址</th> <th>生日</th> </tr>"
        $.each(data,function (index,item){
          html += "<tr> <th>" + item.id + "</th> <th>"+ item.name +"</th> <th>" + item.age +"</th> <th>" + item.sex + "</th> <th> " + item.address + " </th> <th>" + item.birth + "</th> </tr>"
        })
        // 把拼接好的HTML放到studentTable中
        console.log(html);
        studentTable.html(html);
      }
  </script>
</html>
