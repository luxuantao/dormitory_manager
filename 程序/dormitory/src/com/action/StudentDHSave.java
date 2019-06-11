package com.action;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;

public class StudentDHSave extends ActionSupport {
	//下面是Action内用于封装用户请求参数的属性
	private int Building_ID ;
    private int Dormitory_ID ;
    private int Student_ID ;
    private int OldDormitory_ID;

	public int getBuilding_ID() {
		return Building_ID;
	}

	public void setBuilding_ID(int buildingID) {
		Building_ID = buildingID;
	}

	public int getDormitory_ID() {
		return Dormitory_ID;
	}

	public void setDormitory_ID(int dormitoryID) {
		Dormitory_ID = dormitoryID;
	}

	public int getStudent_ID() {
		return Student_ID;
	}

	public void setStudent_ID(int studentID) {
		Student_ID = studentID;
	}
	
	public int getOldDormitory_ID() {
		return OldDormitory_ID;
	}

	public void setOldDormitory_ID(int oldDormitory_ID) {
		OldDormitory_ID = oldDormitory_ID;
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

		//修改
		StudentBean cnbean=new StudentBean();
		cnbean=new StudentDao().GetBean(Student_ID);
		cnbean.setSD_Date(getNowdate());
		cnbean.setOldDormitory_ID(OldDormitory_ID);
		cnbean.setDormitory_ID(Dormitory_ID);
		new StudentDao().Update3(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('寝室调换成功！');window.location='StudentManager.action';</script>");
		out.flush();out.close();return null;
	}
	
	//获取当前日期
	public String getNowdate(){
		Calendar c=Calendar.getInstance();
		c.add(Calendar.MONTH, 1);
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH);
		int date=c.get(Calendar.DATE);
		String re = year + "-";
		if (month < 10) {
			re += "0" + month + "-";
		} else {
			re += month + "-";
		}
		if (date < 10) {
			re += "0" + date;
		} else {
			re += date;
		}
		return re;
	}
}
