package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;

public class StudentRZ extends ActionSupport {
	//������Action�����ڷ�װ�û��������������
	private List<BuildingBean> buildinglist;
	private List<DormitoryBean> dormitorylist;

	public List<BuildingBean> getBuildinglist() {
		return buildinglist;
	}

	public void setBuildinglist(List<BuildingBean> buildinglist) {
		this.buildinglist = buildinglist;
	}

	public List<DormitoryBean> getDormitorylist() {
		return dormitorylist;
	}

	public void setDormitorylist(List<DormitoryBean> dormitorylist) {
		this.dormitorylist = dormitorylist;
	}

	private String BuildingID;
	private String DormitoryID;
	
	public String getBuildingID() {
		return BuildingID;
	}

	public void setBuildingID(String buildingID) {
		BuildingID = buildingID;
	}

	public String getDormitoryID() {
		return DormitoryID;
	}

	public void setDormitoryID(String dormitoryID) {
		DormitoryID = dormitoryID;
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
		
		//��ѯ¥��
		buildinglist=new BuildingDao().GetList("","Building_ID");

		//��ѯ����
		String strWhere="1=1 ";
		if(!(isInvalid(BuildingID)))
		{
			strWhere+=" and DB_BuildingID='"+BuildingID+"'";
		}
//		else{
//			strWhere+=" and 1=2";
//		}
		//��ѯ����
		dormitorylist=new DormitoryDao().GetList(strWhere,"Dormitory_ID");
		
		return SUCCESS;		
	}
	
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
}
