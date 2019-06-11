package com.dao;

import com.db.DBHelper;
import com.bean.StudentBean;

import java.util.*;
import java.sql.*;

public class StudentDao {
	//验证登录
	public String CheckLogin(String username, String password){
		String id = null;
		String sql="select * from student, stu_dor where Student_ID=SD_StudentID and Student_Username='"+username+"' and Student_Password='"+password+"' and SD_State='入住'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				id = rs.getString("Student_ID");
			}
		}
		catch(SQLException ex){}
		return id;
	}
	
	//验证密码
	public boolean CheckPassword(String id, String password){
		boolean ps = false;
		String sql="select * from student, stu_dor where Student_ID=SD_StudentID and Student_ID='"+id+"' and Student_Password='"+password+"' and SD_State='入住'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				ps=true;
			}
		}
		catch(SQLException ex){}
		return ps;
	}
	
	//获取所有列表
	public List<StudentBean> GetAllList(String strwhere,String strorder){
		String sql="select * from student, stu_dor, dormitory"
				+ " where SD_StudentID=Student_ID and SD_DormitoryID=Dormitory_ID";
//		String sql = "select * from stu_dor_view where 1=1";
		
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}

		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<StudentBean> list=new ArrayList<StudentBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				StudentBean cnbean=new StudentBean();
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Password(rs.getString("Student_Password"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Dept(rs.getString("Student_Dept"));
				cnbean.setSD_State(rs.getString("SD_State"));
				cnbean.setSD_Date(rs.getString("SD_Date"));
				cnbean.setDormitory_Name(rs.getString("Dormitory_Name"));
				cnbean.setDormitory_ID(rs.getInt("Dormitory_ID"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//获取列表
	public List<StudentBean> GetList(String strwhere,String strorder){
		String sql="select * from student,dormitory,building,stu_dor,dor_bui "
				+ "where Student_Id=SD_StudentID and SD_DormitoryID=Dormitory_ID and "
				+ "DB_DormitoryID=Dormitory_ID and DB_BuildingID=Building_ID";
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<StudentBean> list=new ArrayList<StudentBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				StudentBean cnbean=new StudentBean();
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Password(rs.getString("Student_Password"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Dept(rs.getString("Student_Dept"));
				cnbean.setStudent_Tel(rs.getString("Student_Tel"));
				cnbean.setDormitory_Name(rs.getString("Dormitory_Name"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
				cnbean.setDormitory_Size(rs.getInt("Dormitory_Size"));
				cnbean.setDormitory_Now(rs.getInt("Dormitory_Now"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//获取指定ID的实体Bean
	public StudentBean GetAllFirstBean(String strwhere){
		String sql="select * from student where "+strwhere;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		StudentBean cnbean=new StudentBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if(rs.next()){
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Password(rs.getString("Student_Password"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Dept(rs.getString("Student_Dept("));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}
	
	//获取指定ID的实体Bean
	public StudentBean GetFirstBean(String strwhere){
		String sql="select * from student,dormitory,building,stu_dor,dor_bui "
				+ "where Student_Id=SD_StudentID and SD_DormitoryID=Dormitory_ID and "
				+ "DB_DormitoryID=Dormitory_ID and DB_BuildingID=Building_ID";
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		StudentBean cnbean=new StudentBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Password(rs.getString("Student_Password"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Dept(rs.getString("Student_Dept"));
				cnbean.setStudent_Tel(rs.getString("Student_Tel"));
				cnbean.setDormitory_Name(rs.getString("Dormitory_Name"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
				cnbean.setDormitory_Size(rs.getInt("Dormitory_Size"));
				cnbean.setDormitory_Now(rs.getInt("Dormitory_Now"));
				cnbean.setDormitory_ID(rs.getInt("Dormitory_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}
	
	//获取指定ID的实体Bean
	public StudentBean GetAllBean(int id){
		String sql="select * from student where Student_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		StudentBean cnbean=new StudentBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
//				cnbean.setStudent_DomitoryID(rs.getInt("Student_DomitoryID"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Password(rs.getString("Student_Password"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Dept(rs.getString("Student_Dept"));
//				cnbean.setStudent_State(rs.getString("Student_State"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}
	
	//获取指定用户名的实体Bean
	public StudentBean GetBeanByUsername(String username){
		String sql="select * from student where Student_Username='"+username+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		StudentBean cnbean=new StudentBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}
	
	//获取指定ID的实体Bean
	public StudentBean GetBean(int id){
		String sql="select * from student,dormitory,stu_dor"
				+ " where Student_ID='"+id+"' and Student_ID=SD_StudentID and Dormitory_ID=SD_DormitoryID";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		StudentBean cnbean=new StudentBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Password(rs.getString("Student_Password"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Dept(rs.getString("Student_Dept"));
				cnbean.setStudent_Tel(rs.getString("Student_Tel"));
				cnbean.setDormitory_ID(rs.getInt("Dormitory_ID"));
				cnbean.setDormitory_Name(rs.getString("Dormitory_Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}
	
	//添加学生基本信息
	public void Add(StudentBean cnbean){
		String sql="insert into student (";
		sql+="Student_Username,Student_Password,Student_Name,Student_Sex,Student_Dept,Student_Tel";
		sql+=") values(";
		sql+="'"+cnbean.getStudent_Username()+"','"+cnbean.getStudent_Password()+"','"+cnbean.getStudent_Name()+"','"+cnbean.getStudent_Sex()+"','"+cnbean.getStudent_Dept()+"','"+cnbean.getStudent_Tel()+"'";
		sql+=")";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//添加学生寝室信息
	public void Add2(StudentBean cnbean){
		String sql="insert into stu_dor (";
		sql+="SD_StudentID,SD_DormitoryID,SD_State,SD_Date";
		sql+=") values(";
		sql+="'"+cnbean.getStudent_ID()+"','"+cnbean.getDormitory_ID()+"','"+
				cnbean.getSD_State()+"','"+cnbean.getSD_Date()+"'"; 
		sql+=")";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
//		sql="update Dormitory set Dormitory_Now=Dormitory_Now+1 where Dormitory_ID='"+cnbean.getDormitory_ID()+"'";
//		stat = null;
//		rs = null;
//		conn = new DBHelper().getConn();
//		try{
//			stat = conn.createStatement();
//			stat.executeUpdate(sql);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (conn != null)
//					conn.close();
//				if (stat != null)
//					stat.close();
//				if (rs != null)
//					rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	//修改学生基本信息
	public void Update(StudentBean cnbean){
		String sql="update student set ";
		sql+="Student_Username='"+cnbean.getStudent_Username()+"',";
		sql+="Student_Password='"+cnbean.getStudent_Password()+"',";
		sql+="Student_Name='"+cnbean.getStudent_Name()+"',";
		sql+="Student_Sex='"+cnbean.getStudent_Sex()+"',";
		sql+="Student_Dept='"+cnbean.getStudent_Dept()+"',";
		sql+="Student_Tel='"+cnbean.getStudent_Tel()+"'";
		sql+=" where Student_ID='"+cnbean.getStudent_ID()+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//迁出
	public void Update2(StudentBean cnbean){
		String sql="update stu_dor set ";
		sql+="SD_State='"+cnbean.getSD_State()+"',";
		sql+="SD_Date='"+cnbean.getSD_Date()+"'";
		sql+=" where SD_StudentID='"+cnbean.getStudent_ID()+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		sql="update dormitory set Dormitory_Now=Dormitory_Now-1 where Dormitory_ID='"+cnbean.getDormitory_ID()+"'";
		stat = null;
		rs = null;
		conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//调换
	public void Update3(StudentBean cnbean){
		String sql="update stu_dor set ";
		sql+="SD_DormitoryID='"+cnbean.getDormitory_ID()+"',";
		sql+="SD_Date='"+cnbean.getSD_Date()+"'";
		sql+=" where SD_StudentID='"+cnbean.getStudent_ID()+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		sql="update dormitory set Dormitory_Now=Dormitory_Now+1 where Dormitory_ID='"+cnbean.getDormitory_ID()+"'";
		stat = null;
		rs = null;
		conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		sql="update dormitory set Dormitory_Now=Dormitory_Now-1 where Dormitory_ID='"+cnbean.getOldDormitory_ID()+"'";
		stat = null;
		rs = null;
		conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//删除
	public void Delete(String strwhere){
		String sql="delete from student where ";
		sql+=strwhere;
//		System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//对应寝室现有人数减一
	public void Delete2(String strwhere){
		String sql="update dormitory set Dormitory_Now=Dormitory_Now-1 where ";
		sql+=strwhere;
//		System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
}
