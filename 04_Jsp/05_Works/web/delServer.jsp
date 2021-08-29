<%@ page import="impl.StudentDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: romantic
  Date: 2021/8/28
  Time: 1:53 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp"%>
<%
    String id = request.getParameter("id");
    new StudentDaoImpl().deleteStudent(Integer.parseInt(id));
    response.sendRedirect("index.jsp");
%>
