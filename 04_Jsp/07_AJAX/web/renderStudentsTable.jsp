<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>渲染学生列表</title>
</head>
<script src="resources/jquery/jquery-3.6.0.min.js"></script>
<body>
    <div align="center">
        <input type="button" value="渲染数据表格" id="btn">
        <table id="studentTable" cellspacing="2px" cellpadding="2px" border="red solid 1px" width="100%">
            <tr>
                <th>ID号</th>
                <th>名字</th>
                <th>地址</th>
                <th>年龄</th>
                <th>性别</th>
                <th>生日</th>
            </tr>
        </table>
    </div>
</body>
<script>
    $("#btn").click(function (){
        $.post({
            url:"students.do",
            type:"get",
            dataType:"json",
            success:function (res){         // 请求之后的回调
                console.log("请求成功");
                console.log(res);
                renderTable(res);
            },
            error:function (){
                console.log("请求失败...")
            }
        })

        function renderTable(data){
            let table = $("#studentTable");
            let html = table.html();
            $(data).each(function (index,item){
                html += "<tr> <th>"+ item.id +"</th> <th>"+ item.name +"</th> <th> " + item.address + "</th> <th>" + item.age + "</th> <th>" + item.sex +" </th> <th> " + item.birth +"</th> </tr>";
            })
        }
    })
</script>
</html>
