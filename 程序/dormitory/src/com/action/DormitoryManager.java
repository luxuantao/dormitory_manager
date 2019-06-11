package com.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;

public class DormitoryManager extends ActionSupport {
	//������Action�����ڷ�װ�û��������������
	private List<DormitoryBean> list;
	
	public List<DormitoryBean> getList() {
		return list;
	}
	public void setList(List<DormitoryBean> list) {
		this.list = list;
	}
	
	private List<DormitoryBean> list2 = new ArrayList<DormitoryBean>();
	
	public List<DormitoryBean> getList2() {
		return list2;
	}
	public void setList2(List<DormitoryBean> list2) {
		this.list2 = list2;
	}
	
	private String SearchRow;
	private String SearchKey;
	
	public String getSearchRow() {
		return SearchRow;
	}
	public void setSearchRow(String searchRow) {
		SearchRow = searchRow;
	}
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}
	
	private List<BuildingBean> buildinglist;
	
	public List<BuildingBean> getBuildinglist() {
		return buildinglist;
	}
	public void setBuildinglist(List<BuildingBean> buildinglist) {
		this.buildinglist = buildinglist;
	}
	
	private String DB_BuildingID;
	
	public String getDB_BuildingID() {
		return DB_BuildingID;
	}
	public void setDB_BuildingID(String db_BuildingID) {
		DB_BuildingID = db_BuildingID;
	}
	
	private int currentPage = 1;
	private int pageSize = 5;
	private int totalPage;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getpageSize() {
		return pageSize;
	}
	public void setpageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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
		//��ѯ����
		String strWhere="1=1";
		if(!(isInvalid(SearchKey)))
		{
			if (SearchRow.equals("Dormitory_Name")) {
				strWhere+=" and "+SearchRow+" like '%"+SearchKey+"%'";
			} else {
				strWhere+=" and "+SearchRow+"='"+SearchKey+"'";
			}
		}
		if(!(isInvalid(DB_BuildingID)))
		{
			strWhere+=" and DB_BuildingID='"+DB_BuildingID+"'";
		}
		
		//��ѯ����¥��
		buildinglist=new BuildingDao().GetList("","Building_ID");
		
		//��ѯ����
		list=new DormitoryDao().GetList2(strWhere,"Dormitory_ID");
		
		setTotalPage((int) Math.ceil((double) list.size() / (double) pageSize));
		
		for (int i = pageSize * (currentPage - 1); i < pageSize * currentPage && i < list.size(); ++i) {
			list2.add(list.get(i));
		}
		
		return SUCCESS;
	}
	
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
}
