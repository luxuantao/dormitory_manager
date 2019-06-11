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
<script language="JavaScript">
function mycheck(){
   if(isNull(form1.Student_ID.value)){  
   alert("请输入学生学号！"); 
   return false;
   }
}

function isNull(str){
	if ( str == "" ) return true;
	var regu = "^[ ]+$";
	var re = new RegExp(regu);
	return re.test(str);
}
</script>
<body>

<%@ include file="Header.jsp"%>

<div class="container-fluid">
  <div class="row">
	<%@ include file="Left.jsp"%>
	<div class="col-sm-9 col-md-10 main">
	  <h3 align="center">学生寝室调换</h3>
	  <hr>
	  <form name="form1" method="post" action="StudentDH.action" onSubmit="return mycheck()" >
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="38%" height="30" align="right">&nbsp;</td>
            <td width="62%">&nbsp;</td>
          </tr>
          <tr>
            <td height="40" align="right"><span style="color:red;">*</span>学生学号：</td>
            <td><input type="text" name="Student_ID" id="Student_ID"></td>
          </tr> 
          <tr>
            <td height="50">&nbsp;</td>
            <td><input type="submit" name="button" id="button" value="确定" class="btn btn-success"></td>
          </tr>
        </table>
      </form>
	</div>
  </div>
</div>
			
</body>
</html>
