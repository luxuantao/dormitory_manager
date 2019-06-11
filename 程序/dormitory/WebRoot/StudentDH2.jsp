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
   if(isNull(form1.Building_ID.value)){
	   alert("请选择楼宇！");
	   return false;
   }
   if(isNull(form1.Dormitory_ID.value)){
	   alert("请选择寝室！");
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
	  <form name="form1" method="post" action="StudentDHSave.action" onSubmit="return mycheck()" >
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="40" align="right">学生学号：</td>
            <td><s:property value='cnbean.Student_ID'/></td>
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
            <td height="40" align="right"><span style="color:red;">*</span>调换到楼宇：</td>
            <td><select name="Building_ID" id="Building_ID" onChange="javascript:window.location='StudentDH.action?Student_ID=<s:property value='cnbean.Student_ID'/>&BuildingID='+this.value;">
              <option value="">请选择</option>
              <s:iterator value="buildinglist">
                <option value="${Building_ID}" <s:if test="BuildingID==Building_ID">selected</s:if>>${Building_Name}</option>
              </s:iterator>
              </select></td>
          </tr>
          <tr>
            <td height="40" align="right"><span style="color:red;">*</span>调换到寝室：</td>
            <td><select name="Dormitory_ID" id="Dormitory_ID">
              <option value="">请选择</option>
              <s:iterator value="dormitorylist">
                <option value="${Dormitory_ID}">${Dormitory_Name}</option>
              </s:iterator>
            </select></td>
          </tr>
          <tr>
            <td height="25"><input name="Student_ID" type="text" style="display:none" id="Student_ID" value="<s:property value='cnbean.Student_ID'/>"></td>
            <td height="25"><input name="OldDormitory_ID" type="text" style="display:none" id="OldDormitory_ID" value="<s:property value='cnbean.Dormitory_ID'/>"></td>
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
