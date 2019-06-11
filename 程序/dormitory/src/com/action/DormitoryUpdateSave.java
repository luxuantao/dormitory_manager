package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;

public class DormitoryUpdateSave extends ActionSupport {
	//������Action�����ڷ�װ�û��������������
	private int Dormitory_ID ;
    private String Dormitory_Name ;
    private int Dormitory_Size ;
    private int DB_BuildingID;
    
	public int getDormitory_ID() {
		return Dormitory_ID;
	}

	public void setDormitory_ID(int dormitoryID) {
		Dormitory_ID = dormitoryID;
	}
	
	public String getDormitory_Name() {
		return Dormitory_Name;
	}

	public void setDormitory_Name(String dormitoryName) {
		Dormitory_Name = dormitoryName;
	}

	public int getDormitory_Size() {
		return Dormitory_Size;
	}

	public void setDormitory_Size(int dormitory_Size) {
		Dormitory_Size = dormitory_Size;
	}
	
	public int getDB_BuildingID() {
		return DB_BuildingID;
	}

	public void setDB_BuildingID(int db_BuildingID) {
		DB_BuildingID = db_BuildingID;
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
		
		//��ѯ�û����Ƿ����
		List<DormitoryBean> list=new DormitoryDao().GetList2("Dormitory_Name='"+Dormitory_Name+"' and DB_BuildingID="+DB_BuildingID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('��¥�����Ѿ����ڸ����Һţ�');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		
		//�޸�
		DormitoryBean cnbean=new DormitoryBean();
//		cnbean=new DormitoryDao().GetBean(Integer.parseInt(Dormitory_ID));
		cnbean=new DormitoryDao().GetBean(Dormitory_ID);
		cnbean.setDormitory_Name(Dormitory_Name);
		cnbean.setDormitory_Size(Dormitory_Size);
		new DormitoryDao().Update(cnbean);
		    
		//��ת
		out.print("<script language='javascript'>alert('�޸ĳɹ���');window.location='DormitoryManager.action';</script>");
		out.flush();out.close();return null;
	}
}
