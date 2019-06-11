package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;

public class DormitoryUpdate extends ActionSupport {
	//下面是Action内用于封装用户请求参数的属性
	private String Dormitory_ID;
	private DormitoryBean cnbean;
	
	public String getDormitory_ID() {
		return Dormitory_ID;
	}

	public void setDormitory_ID(String studentID) {
		Dormitory_ID = studentID;
	}

	public DormitoryBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(DormitoryBean cnbean) {
		this.cnbean = cnbean;
	}

	private List<BuildingBean> list;
	public List<BuildingBean> getList() {
		return list;
	}
	public void setList(List<BuildingBean> list) {
		this.list = list;
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
		
		//查询所有楼宇
		list=new BuildingDao().GetList("","Building_ID");
		//查询
		cnbean=new DormitoryDao().GetBean(Integer.parseInt(Dormitory_ID));
		return SUCCESS;
		
	}
}
