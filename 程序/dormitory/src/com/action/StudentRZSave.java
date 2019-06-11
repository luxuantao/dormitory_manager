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

public class StudentRZSave extends ActionSupport {
	//下面是Action内用于封装用户请求参数的属性
	private int Building_ID ;
    private int Dormitory_ID ;
    private String Student_Username ;
    private String Student_Password ;
    private String Student_Name ;
    private String Student_Sex ;
    private String Student_Dept ;
    private String Student_Tel ;
    
	public String getStudent_Password() {
		return Student_Password;
	}

	public void setStudent_Password(String studentPassword) {
		Student_Password = studentPassword;
	}

	public String getStudent_Name() {
		return Student_Name;
	}

	public void setStudent_Name(String studentName) {
		Student_Name = studentName;
	}

	public String getStudent_Sex() {
		return Student_Sex;
	}

	public void setStudent_Sex(String studentSex) {
		Student_Sex = studentSex;
	}

	public String getStudent_Dept() {
		return Student_Dept;
	}

	public void setStudent_Dept(String student_Dept) {
		Student_Dept = student_Dept;
	}
	
	public String getStudent_Tel() {
		return Student_Tel;
	}

	public void setStudent_Tel(String student_Tel) {
		Student_Tel = student_Tel;
	}
	
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

	public String getStudent_Username() {
		return Student_Username;
	}

	public void setStudent_Username(String studentUsername) {
		Student_Username = studentUsername;
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
		
		//查询用户名是否存在
		List<StudentBean> list=new StudentDao().GetList("Student_Username='"+Student_Username+"'", "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('用户名已经存在！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		
		//添加
		StudentBean cnbean=new StudentBean();
		cnbean.setStudent_Username(Student_Username);
		cnbean.setStudent_Password(Student_Password);
		cnbean.setStudent_Name(Student_Name);
		cnbean.setStudent_Sex(Student_Sex);
		cnbean.setStudent_Dept(Student_Dept);
		cnbean.setStudent_Tel(Student_Tel);
		new StudentDao().Add(cnbean);
		
		cnbean=new StudentDao().GetBeanByUsername(Student_Username);
		cnbean.setSD_State("入住");
		cnbean.setDormitory_ID(Dormitory_ID);
		cnbean.setSD_Date(getNowdate());
		new StudentDao().Add2(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('入住成功！');window.location='StudentManager.action';</script>");
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
