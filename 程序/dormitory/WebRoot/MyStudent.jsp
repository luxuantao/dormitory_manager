<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
	  <h3 align="center">学生管理</h3>
	  <hr>
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td width="100%" height="50" align="center" style="color:red;">请先选择楼宇</td>
		  </tr>
		  <s:iterator id="aa" value="list">
			  <tr>
			    <td height="30" align="center">
			      <a href="MyStudentList.action?Building_ID=${TB_BuildingID}">${Building_Name}</a>
			    </td> 
			  </tr>
		  </s:iterator>
		</table>
	</div>
  </div>
</div>

</body>
</html>
