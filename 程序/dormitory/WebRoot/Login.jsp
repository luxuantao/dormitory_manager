<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>"> 
<title>华东师范大学宿舍管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	body {
		margin: 0;
		padding: 0;
		font-family: sans-serif;
       	background: #363636;
	}
	.box {
		padding: 40px;
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
		background: #191919;
        text-align: center; 
        border:10px solid;  
		border-radius:25px;
	} 
	.box h1 {
		color: white;
		text-transform: uppercase;
		font-weight: 500;
	}
	.box input[type='text'],
	.box input[type='password'] {
		border: 0;
		background: none;
		display: block;
		margin: 20px auto;
		text-align: center;
		border: 2px solid #3498db;
		padding: 14px 10px;
		width: 200px;
		outline: none;
		color: white;
		border-radius: 24px;
		transition: 0.25s;
	}
	.box input[type='text']:focus,
	.box input[type='password']:focus {
		width: 280px;
		border-color: #2ecc71;
	}
	.submit {
		border: 0;
		background: none;
		margin: 20px auto;
		margin-top: 0;
		display: inline-block;
		text-align: center;
		border: 2px solid #3498db;
		padding: 10px 40px;
		outline: none;
		color: white;
		border-radius: 24px;
		transition: 0.25s;
		cursor: pointer;
		text-decoration: none;
		font-size: 12px;
	}
	.submit:hover {
		background: #2ecc71;
		border-color: #2ecc71;
	}
	
	.shortselect{  
	    background:#fafdfe;  
	    height:28px;  
	    width:100px;  
	    line-height:28px;  
	    border:1px solid #9bc0dd;  
	    -moz-border-radius:2px;  
	    -webkit-border-radius:2px;  
	    border-radius:2px;  
	}
</style>
</head>
<script language="JavaScript">
function mycheck() {
   if (isNull(form1.Type.value)) {  
	   alert("请选择身份！"); 
	   return false;
   }
   if (isNull(form1.Username.value)) {  
	   alert("请输入用户名！"); 
	   return false;
   }
   if (isNull(form1.Password.value)) {
	   alert("请输入密码！");
	   return false;
   }  
}

function isNull(str) {
	if ( str == "" ) return true;
	var regu = "^[ ]+$";
	var re = new RegExp(regu);
	return re.test(str);
}
</script>
<body>
    <form name="form1" action="GoLogin.action" class="box" method="post" onSubmit="return mycheck()">
    	<h1>华东师范大学-宿舍管理系统</h1>  
    	<br>
		<span style="color:red"><%if(request.getAttribute("Msg")!=null){%>
	    <%=request.getAttribute("Msg")%>
	    <%}%></span>
	    <br><br>
	    <span style="color:white">身份类型：</span> 
		<select name="Type" id="Type" class="shortselect">
          <option value="" disabled="disabled">请选择</option>
          <option value="系统管理员">系统管理员</option>
          <option value="宿管老师">宿管老师</option>
          <option value="学生">学生</option>
        </select>
        <br>
		<input type="text" name="Username" id="Username" class="text1" placeholder="请输入用户名"/>
        <input type="password" name="Password" id="Password" class="text1" placeholder="请输入密码"/>
        <input type="submit" name="button" id="button" value="登录" class="submit">
    </form>
</body>
</html>
