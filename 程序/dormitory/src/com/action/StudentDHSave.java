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
	//������Action�����ڷ�װ�û��������������
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

		//�޸�
		StudentBean cnbean=new StudentBean();
		cnbean=new StudentDao().GetBean(Student_ID);
		cnbean.setSD_Date(getNowdate());
		cnbean.setOldDormitory_ID(OldDormitory_ID);
		cnbean.setDormitory_ID(Dormitory_ID);
		new StudentDao().Update3(cnbean);
		    
		//��ת
		out.print("<script language='javascript'>alert('���ҵ����ɹ���');window.location='StudentManager.action';</script>");
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
