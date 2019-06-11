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
<body>

<%@ include file="Header.jsp"%>

<div class="container-fluid">
  <div class="row">
	<%@ include file="Left.jsp"%>
	<div class="col-sm-9 col-md-10 main">
	  <h3 align="center">楼宇管理</h3>
	  <hr>
      <form name="form1" method="post" action="BuildingManager.action">
	    <table width="100%%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	      <td width="28%" height="30" style="padding-left:20px;"><a href="BuildingAdd.jsp" class="btn btn-info" role="button">添加楼宇</a></td>
	      <td width="72%">名称：
	        <input name="SearchKey" type="text" class="text1" id="SearchKey">
	        <input type="submit" name="button" id="button" value="查询" class="btn btn-success"></td>
	      </tr> 
	    </table> 
	  </form>
	    <table class="table table-bordered table-hover">
	      <tr align="center">
	        <td height="25" bgcolor="#D5E4F4"><strong>名称</strong></td>
	        <td bgcolor="#D5E4F4"><strong>类型</strong></td>
	        <td bgcolor="#D5E4F4"><strong>操作</strong></td>
	      </tr>
	      <s:iterator id="aa" value="list2">
	        <tr align="center">
	          <td height="25" align="center">${Building_Name}</td>
	          <td>${Building_Type}</td>
	          <td align="center">
	            <a href="TBManager.action?Building_ID=${Building_ID}">查看宿管老师</a>  
	            <a href="BuildingUpdate.action?Building_ID=${Building_ID}">修改</a> 
<%-- 	            <a href="BuildingDel.action?Building_ID=${Building_ID}" onClick="return confirm('确定要删除该楼宇吗？')">删除</a> --%>
	          </td>
	        </tr>
	      </s:iterator>
	    </table>
	    <center>
	        <div>
		               共计<s:property value="totalPage"/>页
		        <s:if test="totalPage>=1">,当前为第<s:property value="currentPage"/>页</s:if>
		        <br><br>
		        <s:if test="currentPage>1">
		        	<a href="BuildingManager.action?currentPage=1">首页</a>
		        	<a href="BuildingManager.action?currentPage=<s:property value='currentPage-1'/>">上一页</a>
		        </s:if>
		        <s:if test="currentPage<totalPage">
		        	<a href="BuildingManager.action?currentPage=<s:property value='currentPage+1'/>">下一页</a>
		        	<a href="BuildingManager.action?currentPage=<s:property value='totalPage'/>">尾页</a>
		        </s:if>
	        </div>
        </center>
	</div>
  </div>
</div>	

</body>
</html>
