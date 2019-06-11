package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;

public class StudentDH extends ActionSupport {
	//下面是Action内用于封装用户请求参数的属性
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

	private int Student_ID;
	
	public int getStudent_ID() {
		return Student_ID;
	}

	public void setStudent_ID(int student_ID) {
		Student_ID = student_ID;
	}
	
	private StudentBean cnbean;
	
	public StudentBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(StudentBean cnbean) {
		this.cnbean = cnbean;
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
		
		//查询是否存在
		List<StudentBean> list=new StudentDao().GetList("Student_ID='"+Student_ID+"'and SD_State='入住'", "");
		if(list.size()<1)
		{
			out.print("<script language='javascript'>alert('学号不存在，或学生未处于入住状态！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		
		//查询楼宇
		buildinglist=new BuildingDao().GetList("","Building_ID");
		
		//查询条件
		String strWhere="1=1 ";
		if(!(isInvalid(BuildingID)))
		{
			strWhere+=" and DB_BuildingID='"+BuildingID+"'";
		}
//		else{
//			strWhere+=" and 1=2";
//		}
		//查询寝室
		dormitorylist=new DormitoryDao().GetList(strWhere,"Dormitory_ID");
		
		//查询学生信息
		cnbean=new StudentDao().GetFirstBean("Student_ID='"+Student_ID+"'");
		
		return SUCCESS;
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}	
}
