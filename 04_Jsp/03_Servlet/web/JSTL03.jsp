<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.domain.Student" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forEach循环标签</title>
</head>
<body>
    <%
        request.setAttribute("num",50);
        request.setAttribute("nums", Arrays.asList("11","22","33","44","55","66","77","88","99"));
        request.setAttribute("persons",Arrays.asList(
                new Student("猫羽雫",16,new Date()),
                new Student("美美",12,new Date()),
                new Student("shark",18,new Date())
        ));
    %>


</body>
<script>
    /*
        begin:起始索引
        end:终止索引
        step:跨步数 默认是1
        var:别名
        items: 待遍历数据容器
        varStatus:每次遍历的状态信息别名
            index : 遍历下标索引
            first : 是否是第一个元素
            last : 是否是最后一个元素
            count:第几次循环
     */
    <c:forEach begin="1" end="100" step="2" var="sn">
        document.write(${sn} + " ");
    </c:forEach>
        document.write("<br>") // 换行
    <c:forEach items="${nums}" begin="0" end="100" step="1" varStatus="sn">
        document.write("${sn.index} " + "${sn.first} " + "${sn.last} " + "${sn.count}" + " ${nums.get(sn.index)}")
        document.write("<br>")
    </c:forEach>
        document.write("<br>")
    // 遍历对象（重点）
    <c:forEach items="${persons}" var="p">
        document.write("${p.name}" + " ${p.age} " + " ${p.birth}")
        document.write("<br>")
    </c:forEach>
</script>
</html>
