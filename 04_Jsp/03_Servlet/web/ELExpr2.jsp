<%@ page import="com.domain.Student" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Arrays" %>
<%--
  Created by IntelliJ IDEA.
  User: romantic
  Date: 2021/8/28
  Time: 11:57 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ELExpr2.jsp</title>
</head>
<body>
<%--
    使用EL表达式来取值
    通过直接数据存储的key来获得value，然后会有一个优先级，最小的优先级最高
    想要取指定域里的值需要使用xxxScope

  --%>
<%
    request.setAttribute("name","zhangsan");
    request.setAttribute("student",new Student("李四",23));
    request.setAttribute("list", Arrays.asList(new Student[]{new Student("张三", 1), new Student("王武", 2)}));
    HashMap map = new HashMap<String,Student>();
    map.put("1",new Student("2",3));
    map.put("2",new Student("3",4));
    request.setAttribute("map",map);
//    pageContext.setAttribute("name","12321421sadasdsa");
    session.setAttribute("name","sessionvalue");
%>
    ${name}&nbsp;|
    ${student}&nbsp;|
    ${list}&nbsp;|
    ${list[0]}&nbsp;|
    ${list[1]}&nbsp;|
    ${map}|
    ${map.get("1")}|
    ${map.get("2")}|
    <h1>------------</h1>
    <%
        // request.getAttribute()才是获取域里的方法
        Object name = request.getAttribute("name");
        // 请求来获取值，根本就没有请求
        String value = request.getParameter("name");
//        out.write(value);   // 这行代码报错
        out.write(name.toString());

//        out.write(session.getAttribute("name"));
    %>
        ${requestScope.name};
        ${sessionScope.name};

<%--  1 = Student(name=2,age=3...)  --%>

</body>
</html>



