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
	  <h3 align="center">我的缺寝记录</h3>
	  <hr>
      <table class="table table-bordered table-hover">
         <tr>
           <td bgcolor="#D5E4F4"><strong>日期</strong></td>
           <td bgcolor="#D5E4F4"><strong>备注</strong></td>
           <td bgcolor="#D5E4F4"><strong>登记老师</strong></td>
         </tr>
         <s:iterator id="aa" value="list2">
           <tr>
             <td>${Log_Date}</td>
             <td>${Log_Reason}</td>
             <td>${Teacher_Name}</td>
           </tr>
         </s:iterator>
       </table>
       <center>
	        <div>
		               共计<s:property value="totalPage"/>页
		        <s:if test="totalPage>=1">,当前为第<s:property value="currentPage"/>页</s:if>
		        <br><br>
		        <s:if test="currentPage>1">
		        	<a href="StudentLog.action?currentPage=1">首页</a>
		        	<a href="StudentLog.action?currentPage=<s:property value='currentPage-1'/>">上一页</a>
		        </s:if>
		        <s:if test="currentPage<totalPage">
		        	<a href="StudentLog.action?currentPage=<s:property value='currentPage+1'/>">下一页</a>
		        	<a href="StudentLog.action?currentPage=<s:property value='totalPage'/>">尾页</a>
		        </s:if>
	        </div>
        </center>
	</div>
  </div>
</div>
</body>
</html>
