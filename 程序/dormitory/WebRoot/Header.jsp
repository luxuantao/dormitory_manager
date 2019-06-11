<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse">
   <a class="navbar-brand">华东师范大学--宿舍管理系统</a>
   <%if(session.getAttribute("type").toString().equals("1")){%>
   <a class="navbar-brand">管理员</a>
   <%}%>
   <%if(session.getAttribute("type").toString().equals("2")){%>
   <a class="navbar-brand">宿管老师</a>
   <%}%>
   <%if(session.getAttribute("type").toString().equals("3")){%>
   <a class="navbar-brand">学生</a>
   <%}%>
</nav>
