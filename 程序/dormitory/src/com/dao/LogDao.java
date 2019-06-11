package com.dao;

import com.db.DBHelper;
import com.bean.LogBean;

import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;

public class LogDao {
	//获取列表
	public List<LogBean> GetList(String strwhere, String strorder){
		String sql="select * from log, teacher, stu_dor, student, building ,dor_bui, dormitory"
				+ " where Log_TeacherID=Teacher_ID and SD_StudentID=Student_ID and Log_StudentID=Student_ID "
				+ "and DB_BuildingID=Building_ID and Dormitory_ID=SD_DormitoryID and Dormitory_ID=DB_DormitoryID";
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
		List<LogBean> list=new ArrayList<LogBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				LogBean cnbean=new LogBean();
				cnbean.setLog_ID(rs.getInt("Log_ID"));
				cnbean.setLog_StudentID(rs.getInt("Log_StudentID"));
				cnbean.setLog_Date(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("Log_Date")));
				cnbean.setLog_Reason(rs.getString("Log_Reason"));
				cnbean.setTeacher_Name(rs.getString("Teacher_Name"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Dept(rs.getString("Student_Dept"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Dept(rs.getString("Student_Dept"));
				cnbean.setDormitory_Name(rs.getString("Dormitory_Name"));
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
	
	//添加
	public void Add(LogBean cnbean){
		String sql="insert into log (";
		sql+="Log_StudentID,Log_TeacherID,Log_Date,Log_Reason";
		sql+=") values(";
		sql+="'"+cnbean.getLog_StudentID()+"','"+cnbean.getLog_TeacherID()+"','"+cnbean.getLog_Date()+"','"+cnbean.getLog_Reason()+"'";
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

	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
}
