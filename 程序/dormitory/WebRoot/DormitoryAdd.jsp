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
   if(isNull(form1.DB_BuildingID.value)){  
	   alert("请选择楼宇！"); 
	   return false;
   }
   if(isNull(form1.Dormitory_Name.value)){
	   alert("请输入寝室号！");
	   return false;
   }
   if(isNull(form1.Dormitory_Size.value)){
	   alert("请输入寝室大小！");
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
	  <h3 align="center">添加宿舍</h3>
	  <hr>
      <form name="form1" method="post" action="DormitoryAddSave.action" onSubmit="return mycheck()" >
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="33%" height="30" align="right">&nbsp;</td>
            <td width="67%">&nbsp;</td>
          </tr>
          <tr>
            <td height="40" align="right"><span style="color:red;">*</span>楼宇：</td>
            <td><select name="DB_BuildingID" id="DB_BuildingID">
              <option value="" disabled="disabled">请选择</option>
              <s:iterator id="aa" value="list">
                <option value="${Building_ID}">${Building_Name}</option>
              </s:iterator>
              </select></td>
          </tr>
          <tr>
            <td height="40" align="right"><span style="color:red;">*</span>寝室号：</td>
            <td><input name="Dormitory_Name" type="text" id="Dormitory_Name"></td>
          </tr>
          <tr>
            <td height="40" align="right"><span style="color:red;">*</span>寝室大小：</td>
            <td><input name="Dormitory_Size" type="text" id="Dormitory_Size"></td>
          </tr>
          <tr>
            <td height="50">&nbsp;</td>
            <td><input type="submit" name="button" id="button" value="添加" class="btn btn-success">
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
