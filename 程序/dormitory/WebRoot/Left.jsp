<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="col-sm-3 col-md-2 sidebar" style="height:500px; border-right:thick dotted;" >
  <ul class="nav nav-sidebar">
    <li><a href="Index.jsp">首页</a></li> 
    <%if(session.getAttribute("type").toString().equals("1")){%>
    <li><a href="TeacherManager.action">宿管老师管理</a></li>
    <li><a href="BuildingManager.action">楼宇管理</a></li> 
    <li><a href="DormitoryManager.action">宿舍管理</a></li>
    <li><a href="StudentManager.action">学生管理</a></li>
    <li><a href="StudentRZ.action">学生入住登记</a></li>
    <li><a href="StudentDH.jsp">学生寝室调换</a></li> 
    <li><a href="StudentQC.jsp">学生迁出登记</a></li>
    <li><a href="AdminLog.action">学生缺寝记录</a></li>
<!--     <li><a href="OutList.action">迁出记录</a></li> -->
    <%}%>
    <%if(session.getAttribute("type").toString().equals("2")){%>
    <li><a href="MyStudent.action">学生管理</a></li>
    <li><a href="MyLog.action">学生缺寝记录</a></li>
    <%}%>
    <%if(session.getAttribute("type").toString().equals("3")){%>
    <li><a href="StudentLog.action">我的缺寝记录</a></li>
    <%}%>
    <li><a href="PasswordUpdate.jsp">修改密码</a></li>
	<li><a href="Quit.action" onclick="return confirm('确定要退出系统吗？')">退出系统</a></li>
  </ul>
</div>
