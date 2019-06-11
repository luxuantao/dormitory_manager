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

public class LogAddSave extends ActionSupport {
	//下面是Action内用于封装用户请求参数的属性
//	private String Log_Date ;
    private String Log_Reason ;

//	public String getLog_Date() {
//		return Log_Date;
//	}
//
//	public void setLog_Date(String logDate) {
//		Log_Date = logDate;
//	}

	public String getLog_Reason() {
		return Log_Reason;
	}

	public void setLog_Reason(String logReason) {
		Log_Reason = logReason;
	}

	private String Log_StudentID;
	
	public String getLog_StudentID() {
		return Log_StudentID;
	}

	public void setLog_StudentID(String logStudentID) {
		Log_StudentID = logStudentID;
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
		
		//添加
		LogBean cnbean=new LogBean();
		cnbean.setLog_StudentID(Integer.parseInt(Log_StudentID));
		cnbean.setLog_TeacherID(Integer.parseInt(session.getAttribute("id").toString()));
		cnbean.setLog_Date(getNowdate());
		cnbean.setLog_Reason(Log_Reason);

		new LogDao().Add(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('缺寝登记成功！');window.location='Index.jsp';</script>");
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
