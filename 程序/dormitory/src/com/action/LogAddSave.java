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
	//������Action�����ڷ�װ�û��������������
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

	//�����û������execute����
	public String execute() throws Exception {
		//������룬����ҳ�����
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//����session����
		HttpSession session = ServletActionContext.getRequest().getSession();
		//��֤�Ƿ�������¼
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('���ȵ�¼��');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		//���
		LogBean cnbean=new LogBean();
		cnbean.setLog_StudentID(Integer.parseInt(Log_StudentID));
		cnbean.setLog_TeacherID(Integer.parseInt(session.getAttribute("id").toString()));
		cnbean.setLog_Date(getNowdate());
		cnbean.setLog_Reason(Log_Reason);

		new LogDao().Add(cnbean);
		    
		//��ת
		out.print("<script language='javascript'>alert('ȱ�޵Ǽǳɹ���');window.location='Index.jsp';</script>");
		out.flush();out.close();return null;
	}
	
	//��ȡ��ǰ����
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
