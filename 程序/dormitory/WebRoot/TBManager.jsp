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
   if(isNull(form1.TB_TeacherID.value)){  
	   alert("请选择要添加的管理员！"); 
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
	  <h3 align="center">宿管老师设置</h3>
	  <hr>
      <form name="form1" method="post" action="TBAddSave.action">
        <table width="100%%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="42%" height="30" style="padding-left:20px;"><a href="BuildingManager.action" class="btn btn-info">返回</a></td>
            <td width="58%">添加宿管老师：
              <select name="TB_TeacherID" id="TB_TeacherID">
                <option value="" disabled="disabled">请选择</option>
                <s:iterator value="teacherlist">
                <option value="${Teacher_ID}">${Teacher_Name}</option>
                </s:iterator>
              </select>
              <input type="submit" name="button" id="button" value="添加"  class="btn btn-success">
              <label for="TB_BuildingID"></label>
              <input name="TB_BuildingID" type="text" style="display:none" id="TB_BuildingID" value="${Building_ID}"></td>
          </tr>
        </table>
      </form>
      <table class="table table-bordered table-hover">
        <tr align="center">
          <td height="25" bgcolor="#D5E4F4"><strong>姓名</strong></td>
          <td bgcolor="#D5E4F4"><strong>性别</strong></td>
          <td bgcolor="#D5E4F4"><strong>电话</strong></td>
          <td bgcolor="#D5E4F4"><strong>用户名</strong></td>
          <td bgcolor="#D5E4F4"><strong>操作</strong></td>
        </tr>
        <s:iterator id="aa" value="list">
          <tr align="center">
            <td height="25" align="center">${Teacher_Name}</td>
            <td>${Teacher_Sex}</td>
            <td>${Teacher_Tel}</td>
            <td align="center">${Teacher_Username}</td>
            <td align="center"><a href="TBDel.action?TB_ID=${TB_ID}&Building_ID=${TB_BuildingID}" onClick="return confirm('确定要将该管理员从该楼宇移除吗？')">移除</a></td>
          </tr>
        </s:iterator>
      </table>
	</div>
  </div>
</div>	
 
</body>
</html>
