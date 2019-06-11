package com.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;

public class StudentLog extends ActionSupport {
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
		
		//查询所有
		list=new LogDao().GetList("Log_StudentID="+session.getAttribute("id"),"Log_Date desc");
		
		setTotalPage((int) Math.ceil((double) list.size() / (double) pageSize));
		
		for (int i = pageSize * (currentPage - 1); i < pageSize * currentPage && i < list.size(); ++i) {
			list2.add(list.get(i));
		}
		
		return SUCCESS;
	}
}
