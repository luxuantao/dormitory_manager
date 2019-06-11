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
	  <h3 align="center">宿舍管理</h3>
	  <hr>
	  <form name="form1" method="post" action="DormitoryManager.action">
        <table width="100%%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="22%" height="30" style="padding-left:20px;"><a href="DormitoryAdd.action" class="btn btn-info" role="button">添加宿舍</a></td>
            <td width="78%">
              <select name="DB_BuildingID" id="DB_BuildingID">
              <option value="">全部楼宇</option>
                <s:iterator value="buildinglist">
              <option value="${Building_ID}">${Building_Name}</option>
              </s:iterator>
              </select>
              <select name="SearchRow" id="SearchRow">
                <option value="Dormitory_Name">寝室号</option>
                <option value="Dormitory_Size">寝室大小</option>
                <option value="Dormitory_Now">现有人数</option>
              </select>
              <input name="SearchKey" type="text" id="SearchKey">
              <input type="submit" name="button" id="button" value="查询" class="btn btn-success"></td>
          </tr>
        </table>
      </form>
      <table class="table table-bordered table-hover">
        <tr align="center">
          <td height="25" bgcolor="#D5E4F4"><strong>楼宇名称</strong></td>
          <td bgcolor="#D5E4F4"><strong>寝室号</strong></td>
          <td bgcolor="#D5E4F4"><strong>寝室大小</strong></td>
          <td bgcolor="#D5E4F4"><strong>现有人数</strong></td>
          <td bgcolor="#D5E4F4"><strong>操作</strong></td>
        </tr>
        <s:iterator id="aa" value="list2">
          <tr align="center">
            <td height="25" align="center">${Building_Name}</td>
            <td>${Dormitory_Name}</td>
            <td>${Dormitory_Size}</td>
            <td>${Dormitory_Now}</td>
            <td align="center"><a href="DormitoryUpdate.action?Dormitory_ID=${Dormitory_ID}">修改</a> <a href="DormitoryDel.action?Dormitory_ID=${Dormitory_ID}" onClick="return confirm('确定要删除该宿舍吗？')">删除</a></td>
          </tr>
        </s:iterator>
      </table>
      <center>
        <div>
	               共计<s:property value="totalPage"/>页
	        <s:if test="totalPage>=1">,当前为第<s:property value="currentPage"/>页</s:if>
	        <br><br>
	        <s:if test="currentPage>1">
	        	<a href="DormitoryManager.action?currentPage=1">首页</a>
	        	<a href="DormitoryManager.action?currentPage=<s:property value='currentPage-1'/>">上一页</a>
	        </s:if>
	        <s:if test="currentPage<totalPage">
	        	<a href="DormitoryManager.action?currentPage=<s:property value='currentPage+1'/>">下一页</a>
	        	<a href="DormitoryManager.action?currentPage=<s:property value='totalPage'/>">尾页</a>
	        </s:if>
        </div>
       </center>
	</div>
  </div>
</div>
	
</body>
</html>
