<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>要使用引入的页面的页面2</title>
</head>
<%--
    <jsp:include page="相对 URL 地址" flush="true" />
    前面已经介绍过 include 指令，它是在 JSP 文件被转换成 Servlet 的时候引入文件，而这里的 jsp:include 动作不同，
    插入文件的时间是在页面被请求的时候。以下是 include 动作相关的属性列表。
    | 属性  | 描述                               |
    | ----- | ----------------------------------|
    | page  | 包含在页面中的相对 URL 地址。         |
    | flush | 布尔属性，定义在包含资源前是否刷新缓存区 |

    可以直接导入其他页面
--%>
<jsp:include page="included2.jsp"></jsp:include>
<%
//    out.write(a);  这里是用来导入页面的，在页面接在之后加载，这里不能使用前一个页面的东西
%>
<body>
</body>
</html>