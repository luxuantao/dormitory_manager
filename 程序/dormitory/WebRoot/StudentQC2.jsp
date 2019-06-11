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
	  <h3 align="center">学生迁出登记</h3>
	  <hr>
	  <form name="form1" method="post" action="StudentQCSave.action" onSubmit="return mycheck()" >
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="40" colspan="2" align="center" style="color:red;">迁出后将不可恢复！ 确定要迁出学生吗？</td>
          </tr>
          <tr>
            <td height="40" align="right">学生学号：</td>
            <td><s:property value='cnbean.Student_ID'/></td>
          </tr>
          <tr>
            <td height="40" align="right">学生用户名：</td>
            <td><s:property value='cnbean.Student_Username'/></td>
          </tr>
          <tr>
            <td height="40" align="right">学生姓名：</td>
            <td><s:property value='cnbean.Student_Name'/></td>
          </tr>
          <tr>
            <td height="40" align="right">学生性别：</td>
            <td><s:property value='cnbean.Student_Sex'/></td>
          </tr>
          <tr>
            <td height="40" align="right">目前楼宇：</td>
            <td><s:property value='cnbean.Building_Name'/></td>
          </tr>
          <tr>
            <td height="40" align="right">目前寝室：</td>
            <td><s:property value='cnbean.Dormitory_Name'/></td>
          </tr> 
          <tr>
            <td height="50"><input name="Student_ID" type="text" style="display:none" id="Student_ID" value="<s:property value='cnbean.Student_ID'/>"></td>
            <td><input type="submit" name="button" id="button" value="确定" class="btn btn-success">
              &nbsp;&nbsp;
              <input type="button" name="button2" id="button2" value="返回" onClick="javascript:history.back(-1);" class="btn btn-info"></td>
          </tr>
        </table>
      </form>
	</div>
  </div>
</div>
           
</body>
</html>
