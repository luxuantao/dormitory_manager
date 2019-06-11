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
   if(isNull(form1.Building_Name.value)){  
	   alert("请输入楼宇名称！"); 
	   return false;
   }
   if(isNull(form1.Building_Type.value)){  
	   alert("请输入楼宇类型！"); 
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
	  <h3 align="center">楼宇管理</h3>
	  <hr>
      <form name="form1" method="post" action="BuildingUpdateSave.action" onSubmit="return mycheck()" >
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="33%" height="30" align="right">&nbsp;</td>
            <td width="67%"><input name="Building_ID" type="text" style="display:none" id="Building_ID" value="<s:property value='cnbean.Building_ID'/>"></td>
          </tr>
          <tr>
            <td height="50" align="right"><span style="color:red;">*</span>名称：</td>
            <td><input name="Building_Name" type="text" id="Building_Name" value="<s:property value='cnbean.Building_Name'/>"></td>
          </tr>
          <tr>
            <td height="50" align="right"><span style="color:red;">*</span>类型：</td>
            <td><input name="Building_Type" type="text" id="Building_Type" value="<s:property value='cnbean.Building_Type'/>"></td>
          </tr>
          <tr>
            <td height="50">&nbsp;</td>
            <td><input type="submit" name="button" id="button" value="修改"  class="btn btn-success">
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
