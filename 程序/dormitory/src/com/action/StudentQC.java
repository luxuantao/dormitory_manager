package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;

public class StudentQC extends ActionSupport {
	//������Action�����ڷ�װ�û��������������
	private String Student_ID;
	
	public String getStudent_ID() {
		return Student_ID;
	}

	public void setStudent_ID(String student_ID) {
		Student_ID = student_ID;
	}
	
	private StudentBean cnbean;
	
	public StudentBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(StudentBean cnbean) {
		this.cnbean = cnbean;
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
	
		//��ѯ�Ƿ����
		List<StudentBean> list=new StudentDao().GetList("Student_ID='"+Student_ID+"' and SD_State='��ס'", "");
		if(list.size()<1)
		{
			out.print("<script language='javascript'>alert('ѧ�Ų����ڣ���ѧ��δ������ס״̬��');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		
		//��ѯѧ����Ϣ
		cnbean=new StudentDao().GetFirstBean("Student_ID='"+Student_ID+"'");
		
		return SUCCESS;
	}
}
