<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.apache.struts2.ServletActionContext" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//创建session对象
session = ServletActionContext.getRequest().getSession();
//验证是否正常登录
if(session.getAttribute("id")==null){
	out.print("<script language='javascript'>alert('请先登录！');window.location='Login.jsp';</script>");
	out.flush();out.close();
}

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
   <title>华东师范大学宿舍管理系统</title>
   <base href="<%=basePath%>">
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="bootstrap/dist/js/bootstrap.min.js"></script>
   <script src="bootstrap/dist/jquery/jquery-3.3.1.min.js"></script>
</head>
<body>

<%@ include file="Header.jsp"%>

<div class="container-fluid">
  <div class="row">
	<%@ include file="Left.jsp"%>
	<div class="col-sm-9 col-md-10 main">
	  <h3 align="center">首页</h3>
	  <hr>
	  <br><br><br><br><br><br>
	  <h2 align="center">欢迎使用华东师范大学宿舍管理系统</h2>
	</div>
  </div>
</div>

</body>
</html>
