<%@ page import="impl.StudentDaoImpl" %>
<%@ page import="dao.StudentDao" %>
<%@ page import="entity.Student" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: romantic
  Date: 2021/8/28
  Time: 12:03 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp"%>
<%
    String name = request.getParameter("name");
    String address = request.getParameter("address");
    Integer age = Integer.valueOf(request.getParameter("age"));
    Integer sex = Integer.valueOf(request.getParameter("sex"));
    Date birth = sdf.parse(request.getParameter("birth"));
    StudentDao studentDao = new StudentDaoImpl();
    studentDao.addStudent(new Student(name,address,age,sex,birth));
    response.sendRedirect("index.jsp");
%>
