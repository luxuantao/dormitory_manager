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
	//������Action�����ڷ�װ�û��������������
	private int Dormitory_ID ;
	
	public int getDormitory_ID() {
		return Dormitory_ID;
	}

	public void setDormitory_ID(int dormitory_ID) {
		Dormitory_ID = dormitory_ID;
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
		
		DormitoryBean cnbean=new DormitoryDao().GetBean(Dormitory_ID);
		if(cnbean.getDormitory_Now()!=0)
		{
			out.print("<script language='javascript'>alert('����ͬѧ��ס�ڸ����ң��޷�ɾ����');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		
		//ɾ��
		new DormitoryDao().Delete("Dormitory_ID="+Dormitory_ID);
		    
		return SUCCESS;	
	}
}
