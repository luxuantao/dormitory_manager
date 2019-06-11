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
   if(isNull(form1.Building_ID.value)){
	   alert("请选择楼宇！");
	   return false;
   }
   if(isNull(form1.Dormitory_ID.value)){
	   alert("请选择寝室！");
	   return false;
   }
   if(isNull(form1.Student_Username.value)){  
	   alert("请输入用户名！"); 
	   return false;
   }
   if(isNull(form1.Student_Password.value)){
	   alert("请输入密码！");
	   return false;
   }
   if(isNull(form1.Student_Password2.value)){
	   alert("请输入重复密码！");
	   return false;
   }
   if (form1.Student_Password.value != form1.Student_Password2.value) { 
	   alert("您两次输入的新密码不一致！请重新输入！"); 
	   return false; 
   }  
   if(isNull(form1.Student_Name.value)){
	   alert("请输入姓名！");
	   return false;
   }
   if(isNull(form1.Student_Sex.value)){
	   alert("请选择性别！");
	   return false;
   }
   if(isNull(form1.SD_Date.value)){
	   alert("请选择日期！");
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
	  <h3 align="center">学生入住登记</h3>
	  <hr>
      <form name="form1" method="post" action="StudentRZSave.action" onSubmit="return mycheck()" >
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
       	 <tr>
           <td width="33%" height="0" align="right">&nbsp;</td> 
           <td width="67%">&nbsp;</td>
         </tr>   
         <tr>
           <td height="40" align="right"><span style="color:red;">*</span>入住楼宇：</td>
           <td><select name="Building_ID" id="Building_ID" onChange="javascript:window.location='StudentRZ.action?BuildingID='+this.value;">
             <option value="">请选择</option>
             <s:iterator value="buildinglist">
               <option value="${Building_ID}" <s:if test="BuildingID==Building_ID">selected</s:if>>${Building_Name}</option>
             </s:iterator>
             </select></td>
         </tr>
         <tr>
           <td height="40" align="right"><span style="color:red;">*</span>入住寝室：</td>
           <td><select name="Dormitory_ID" id="Dormitory_ID">
             <option value="">请选择</option>
             <s:iterator value="dormitorylist">
               <option value="${Dormitory_ID}">${Dormitory_Name}</option>
             </s:iterator>
           </select></td>
         </tr>
         <tr> 
           <td height="40" align="right"><span style="color:red;">*</span>用户名：</td>
           <td><input name="Student_Username" type="text" id="Student_Username"></td>
         </tr>
         <tr>
           <td height="40" align="right"><span style="color:red;">*</span>密码：</td>
           <td><input name="Student_Password" type="password" id="Student_Password"></td>
         </tr>
         <tr>
           <td height="40" align="right"><span style="color:red;">*</span>重复密码：</td>
           <td><input name="Student_Password2" type="password" id="Student_Password2"></td>
         </tr>
         <tr>
           <td height="40" align="right"><span style="color:red;">*</span>姓名：</td>
           <td><input name="Student_Name" type="text" id="Student_Name"></td>
         </tr>
         <tr>
           <td height="40" align="right"><span style="color:red;">*</span>性别：</td>
           <td><select name="Student_Sex" id="Student_Sex">
             <option value="" disabled="disabled">请选择</option>
             <option value="男">男</option>
             <option value="女">女</option>
           </select></td>
         </tr>
         <tr>
           <td height="40" align="right">院系：</td>
           <td><input name="Student_Dept" type="text" id="Student_Dept"></td>
         </tr>
         <tr>
           <td height="40" align="right">电话：</td>
           <td><input name="Student_Tel" type="text" id="Student_Tel"></td>
         </tr>
          <tr>
            <td height="50">&nbsp;</td>  
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
