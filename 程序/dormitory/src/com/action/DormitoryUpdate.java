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
	//������Action�����ڷ�װ�û��������������
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
		
		//��ѯ����¥��
		list=new BuildingDao().GetList("","Building_ID");
		//��ѯ
		cnbean=new DormitoryDao().GetBean(Integer.parseInt(Dormitory_ID));
		return SUCCESS;
		
	}
}
