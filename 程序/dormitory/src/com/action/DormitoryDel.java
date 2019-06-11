package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;

public class DormitoryDel extends ActionSupport {
	//下面是Action内用于封装用户请求参数的属性
	private int Dormitory_ID ;
	
	public int getDormitory_ID() {
		return Dormitory_ID;
	}

	public void setDormitory_ID(int dormitory_ID) {
		Dormitory_ID = dormitory_ID;
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
		
		DormitoryBean cnbean=new DormitoryDao().GetBean(Dormitory_ID);
		if(cnbean.getDormitory_Now()!=0)
		{
			out.print("<script language='javascript'>alert('还有同学入住在该寝室，无法删除！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		
		//删除
		new DormitoryDao().Delete("Dormitory_ID="+Dormitory_ID);
		    
		return SUCCESS;	
	}
}
