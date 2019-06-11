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
	//下面是Action内用于封装用户请求参数的属性
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
		
		//查询用户名是否存在
		List<DormitoryBean> list=new DormitoryDao().GetList2("Dormitory_Name='"+Dormitory_Name+"' and DB_BuildingID="+DB_BuildingID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('该楼宇中已经存在该寝室号！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		
		//修改
		DormitoryBean cnbean=new DormitoryBean();
//		cnbean=new DormitoryDao().GetBean(Integer.parseInt(Dormitory_ID));
		cnbean=new DormitoryDao().GetBean(Dormitory_ID);
		cnbean.setDormitory_Name(Dormitory_Name);
		cnbean.setDormitory_Size(Dormitory_Size);
		new DormitoryDao().Update(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('修改成功！');window.location='DormitoryManager.action';</script>");
		out.flush();out.close();return null;
	}
}
