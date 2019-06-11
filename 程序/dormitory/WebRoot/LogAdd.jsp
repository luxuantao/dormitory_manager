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
  <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
</head>
<script language="JavaScript">
function mycheck(){
   if(isNull(form1.Log_Date.value)){  
	   alert("请输入缺寝日期！"); 
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
	  <h3 align="center">学生缺寝登记</h3>
	  <hr>
      <form name="form1" method="post" action="LogAddSave.action" onSubmit="return mycheck()" >
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="50" colspan="2" align="center" style="color:red;">请仔细确认信息是否正确，缺寝登记提交后不可修改！</td>
            </tr>
          <tr>
            <td width="33%" height="30" align="right">学号：</td>
            <td width="67%"><s:property value='cnbean.Student_ID'/>
              <label for="Log_StudentID"></label>
              <input name="Log_StudentID" type="text" style="display:none" id="Log_StudentID" value="<s:property value='cnbean.Student_ID'/>"></td>
          </tr>
          <tr>
            <td height="30" align="right">姓名：</td>
            <td><s:property value='cnbean.Student_Name'/></td>
          </tr>
          <tr>
            <td height="30" align="right">性别：</td>
            <td><s:property value='cnbean.Student_Sex'/></td>
          </tr>
          <tr>
            <td height="30" align="right">院系：</td>
            <td><s:property value='cnbean.Student_Dept'/></td>
          </tr>
          <tr>
            <td height="30" align="right">寝室：</td>
            <td><s:property value='cnbean.Dormitory_Name'/></td>
          </tr>  
<!--           <tr> -->
<%--             <td height="30" align="right"><span style="color:red;">*</span>缺寝日期：</td> --%>
<!--             <td><label for="Log_Date"></label> -->
<!--               <input type="text" name="Log_Date" id="Log_Date" onClick="WdatePicker()" autocomplete="off"></td> -->
<!--           </tr> -->
          <tr>
            <td height="30" align="right">缺寝备注：</td>
            <td><textarea name="Log_Reason" id="Log_Reason" cols="45" rows="5"></textarea></td>
          </tr>
          <tr>
            <td height="60">&nbsp;</td>
            <td><input type="submit" name="button" id="button" value="提交" class="btn btn-success" >
              &nbsp;&nbsp;
              <input type="button" name="button2" id="button2" value="返回" onClick="javascript:history.back(-1);" class="btn btn-info" ></td>
          </tr>
        </table>
      </form>  
	</div>
  </div>
</div>

</body>
</html>
