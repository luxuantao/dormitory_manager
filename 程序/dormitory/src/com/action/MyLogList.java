package com.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;

public class MyLogList extends ActionSupport {
	//下面是Action内用于封装用户请求参数的属性
	private List<LogBean> list;
	
	public List<LogBean> getList() {
		return list;
	}
	public void setList(List<LogBean> list) {
		this.list = list;
	}
	
	private List<LogBean> list2 = new ArrayList<LogBean>();
	
	public List<LogBean> getList2() {
		return list2;
	}
	public void setList2(List<LogBean> list2) {
		this.list2 = list2;
	}
	
	private String Building_ID;
	
	public String getBuilding_ID() {
		return Building_ID;
	}
	public void setBuilding_ID(String buildingID) {
		Building_ID = buildingID;
	}
	
	private List<DormitoryBean> dormitorylist;
	
	public List<DormitoryBean> getDormitorylist() {
		return dormitorylist;
	}
	public void setDormitorylist(List<DormitoryBean> dormitorylist) {
		this.dormitorylist = dormitorylist;
	}
	
	private String SearchRow;
	private String SearchKey;
	
	public String getSearchRow() {
		return SearchRow;
	}
	public void setSearchRow(String searchRow) {
		SearchRow = searchRow;
	}
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}
	
	private String Dormitory_ID;
	
	public String getDormitory_ID() {
		return Dormitory_ID;
	}
	public void setDormitory_ID(String dormitoryID) {
		Dormitory_ID = dormitoryID;
	}
	
	private int currentPage = 1;
	private int pageSize = 5;
	private int totalPage;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getpageSize() {
		return pageSize;
	}
	public void setpageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	//处理用户请求的execute方法
	public String execute() throws Exception {
		//解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//验证是否正常登录
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请先登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}

		//查询条件
		String strWhere="SD_State='入住' and Building_ID="+Building_ID;
		if(!(isInvalid(SearchKey)))
		{
			strWhere+=" and "+SearchRow+" like '%"+SearchKey+"%'";
		}
		if(!(isInvalid(Dormitory_ID)))
		{
			strWhere+=" and Dormitory_ID='"+Dormitory_ID+"'";
		}
		//查询所有
		list=new LogDao().GetList(strWhere,"Log_Date desc");
		
		setTotalPage((int) Math.ceil((double) list.size() / (double) pageSize));
		
		for (int i = pageSize * (currentPage - 1); i < pageSize * currentPage && i < list.size(); ++i) {
			list2.add(list.get(i));
		}
		
		//查询所有寝室
		dormitorylist=new DormitoryDao().GetList2("DB_BuildingID="+Building_ID,"Dormitory_Name");
	
		return SUCCESS;
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
}
