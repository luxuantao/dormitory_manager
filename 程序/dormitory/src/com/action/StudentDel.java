package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;

public class StudentDel extends ActionSupport {
	//������Action�����ڷ�װ�û��������������
	private int Student_ID ;
	private int Dormitory_ID;
	private String SD_State;
	
	public int getStudent_ID() {
		return Student_ID;
	}

	public void setStudent_ID(int userID) {
		Student_ID = userID;
	}
	
	public int getDormitory_ID() {
		return Dormitory_ID;
	}

	public void setDormitory_ID(int dormitory_ID) {
		Dormitory_ID = dormitory_ID;
	}
	
	public String getSD_State() {	
		return SD_State;
	}

	public void setSD_State(String sD_State) {
		SD_State = sD_State;
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
		
		//ɾ��
		new StudentDao().Delete("Student_ID="+Student_ID);
		if (SD_State.equals("��ס")) {
			new StudentDao().Delete2("Dormitory_ID="+Dormitory_ID);
		}
		
		return SUCCESS;
	}
}
