package com.dao;

import com.db.DBHelper;
import com.bean.DormitoryBean;

import java.util.*;
import java.sql.*;

public class DormitoryDao {
	//获取还有空位的寝室列表
	public List<DormitoryBean> GetList(String strwhere,String strorder){
		String sql="select * from dormitory,building,dor_bui "
				+ "where Dormitory_ID=DB_DormitoryID and Building_ID=DB_BuildingID and Dormitory_Size>Dormitory_Now";
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
		List<DormitoryBean> list=new ArrayList<DormitoryBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				DormitoryBean cnbean=new DormitoryBean();
				cnbean.setDormitory_ID(rs.getInt("Dormitory_ID"));
				cnbean.setDormitory_Name(rs.getString("Dormitory_Name"));
				cnbean.setDormitory_Size(rs.getInt("Dormitory_Size"));
				cnbean.setDormitory_Now(rs.getInt("Dormitory_Now"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
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
	
	//获取全部寝室列表
	public List<DormitoryBean> GetList2(String strwhere,String strorder){
		String sql="select * from dormitory,building,dor_bui "
				+ "where Dormitory_ID=DB_DormitoryID and Building_ID=DB_BuildingID";
//		String sql="select * from dor_bui_view where 1=1";
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
		List<DormitoryBean> list=new ArrayList<DormitoryBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				DormitoryBean cnbean=new DormitoryBean();
				cnbean.setDormitory_ID(rs.getInt("Dormitory_ID"));
				cnbean.setDormitory_Name(rs.getString("Dormitory_Name"));
				cnbean.setDormitory_Size(rs.getInt("Dormitory_Size"));
				cnbean.setDormitory_Now(rs.getInt("Dormitory_Now"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
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
	public DormitoryBean GetBean(int id){
		String sql="select * from dormitory where Dormitory_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		DormitoryBean cnbean=new DormitoryBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setDormitory_ID(rs.getInt("Dormitory_ID"));
				cnbean.setDormitory_Name(rs.getString("Dormitory_Name"));
				cnbean.setDormitory_Size(rs.getInt("Dormitory_Size"));
				cnbean.setDormitory_Now(rs.getInt("Dormitory_Now"));
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
	
	//获取指定Name的实体Bean
	public DormitoryBean GetBeanByName(String name){
		String sql="select * from dormitory where Dormitory_Name='"+name+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		DormitoryBean cnbean=new DormitoryBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
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
	
	//添加
	public void Add(DormitoryBean cnbean){
		String sql="insert into dormitory (";
		sql+="Dormitory_Name,Dormitory_Size";
		sql+=") values(";
		sql+="'"+cnbean.getDormitory_Name()+"','"+cnbean.getDormitory_Size()+"'";
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
	
	public void Add2(DormitoryBean cnbean){
		String sql="insert into dor_bui (";
		sql+="DB_DormitoryID,DB_BuildingID";
		sql+=") values(";
		sql+="'"+cnbean.getDormitory_ID()+"','"+cnbean.getDB_BuildingID()+"'";
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
	
	//修改
	public void Update(DormitoryBean cnbean){
		String sql="update dormitory set ";
		sql+="Dormitory_Name='"+cnbean.getDormitory_Name()+"',";
		sql+="Dormitory_Size='"+cnbean.getDormitory_Size()+"'";
		sql+=" where Dormitory_ID='"+cnbean.getDormitory_ID()+"'";
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
	
	//删除
	public void Delete(String strwhere){
		String sql="delete from dormitory where ";
		sql+=strwhere;
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
