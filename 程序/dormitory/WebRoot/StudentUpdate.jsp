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
   if(isNull(form1.Student_Username.value)){  
	   alert("请输入用户名！"); 
	   return false;
   }
   if (document.form1.Student_Password.value != document.form1.Student_Password2.value) { 
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
	  <h3 align="center">修改学生</h3>
	  <hr>
      <form name="form1" method="post" action="StudentUpdateSave.action" onSubmit="return mycheck()" >
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="33%" height="30" align="right">&nbsp;</td>
            <td width="67%"><input name="Student_ID" type="text" style="display:none" id="Student_ID" value="<s:property value='cnbean.Student_ID'/>"></td>
          </tr>
          <tr>
            <td height="40" align="right"><span style="color:red;">*</span>用户名：</td>
            <td><input name="Student_Username" type="text" class="text2" id="Student_Username" value="<s:property value='cnbean.Student_Username'/>"></td>
          </tr>
          <tr>
            <td height="40" align="right">密码：</td>
            <td><input name="Student_Password" type="password" class="text2" id="Student_Password">
              <span style="color:gray">(不修改可不填写)</span></td>
          </tr>
          <tr>
            <td height="40" align="right">重复密码：</td>
            <td><input name="Student_Password2" type="password" class="text2" id="Student_Password2">
              <span style="color:gray">(不修改可不填写)</span></td>
          </tr>
          <tr>
            <td height="40" align="right"><span style="color:red;">*</span>姓名：</td>
            <td><input name="Student_Name" type="text" class="text2" id="Student_Name" value="<s:property value='cnbean.Student_Name'/>"></td>
          </tr>
          <tr>
            <td height="40" align="right"><span style="color:red;">*</span>性别：</td>
            <td><select name="Student_Sex" id="Student_Sex">
              <option value="" disabled="disabled">请选择</option>
              <option value="男" 
              <s:if test='cnbean.Student_Sex=="男"'>selected</s:if>
              >男
              </option>
              <option value="女" 
              <s:if test='cnbean.Student_Sex=="女"'>selected</s:if>
              >女
              </option>
            </select></td>
          </tr>
          <tr>
            <td height="40" align="right">院系：</td>
            <td><input name="Student_Dept" type="text" id="Student_Dept" value="<s:property value='cnbean.Student_Dept'/>"></td>
          </tr>
          <tr>
            <td height="50">&nbsp;</td>
            <td><input type="submit" name="button" id="button" value="修改" class="btn btn-success">
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
