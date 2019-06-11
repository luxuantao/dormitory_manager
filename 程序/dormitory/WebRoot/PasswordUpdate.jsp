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
function mycheck() {
   if (isNull(form1.Password.value)) {  
	   alert("请输入原密码！"); 
	   return false;
   }
   if (isNull(form1.Password2.value)) {
	   alert("请输入新密码！");
	   return false;
   }
   if (isNull(form1.Password3.value)) {
	   alert("请输入重复密码！");
	   return false;
   }
   if (document.form1.Password2.value != document.form1.Password3.value) { 
	   alert("您两次输入的新密码不一致！请重新输入！"); 
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
	   <h3 align="center">修改密码</h3>
	   <hr>
	   <form name="form1" method="post" action="PasswordUpdateSave.action" onSubmit="return mycheck()" >
	     <table width="100%" border="0" cellspacing="0" cellpadding="0">
	       <tr>
	         <td height="50" align="right"><span style="color:red;">*</span>请输入原密码：</td>
	         <td><input name="Password" type="password" class="text2" id="Password">
	           <%if(request.getAttribute("Msg")!=null){%>
	           <span style="color:red;"><%=request.getAttribute("Msg")%></span>
	           <%}%></td>
	       </tr>
	       <tr>
	         <td height="50" align="right"><span style="color:red;">*</span>请输入新密码：</td>
	         <td><input name="Password2" type="password" class="text2" id="Password2"></td>
	       </tr>
	       <tr>
	         <td height="50" align="right"><span style="color:red;">*</span>请重复新密码：</td>
	         <td><input name="Password3" type="password" class="text2" id="Password3"></td>
	       </tr>
	       <tr>
	         <td height="50">&nbsp;</td>
	         <td><button type="submit" class="btn btn-success">修改</button></td>
	       </tr>
	     </table>
	   </form>
	</div>
  </div>
</div>

</body>
</html>
