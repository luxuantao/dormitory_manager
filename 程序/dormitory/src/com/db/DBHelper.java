package com.db;

import java.sql.*;

public class DBHelper {	
	private String dbUrl="jdbc:mysql://localhost:3306/dormitory?characterEncoding=utf-8";
	private String dbUser="root";
	private String dbPassword="12345678";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	//连接数据库
	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(jdbcName);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("驱动加载失败!");
		}
		try {
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败!");
		}
		return conn;		
	}
}
