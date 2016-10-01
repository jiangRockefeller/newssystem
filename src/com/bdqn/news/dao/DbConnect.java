package com.bdqn.news.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;




public class DbConnect {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//jdbc:mysql://localhost:3306/newssystem?useUnicode=true&charaterEncoding=utf-8
			String mysql="jdbc:mysql://localhost:3306/newssystem?characterEncoding=UTF-8";
			conn=DriverManager.getConnection(mysql, "root", "");
			//System.out.println("数据库连接成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println("数据库连接已关闭");
	}
	//获取系统时间,以yyyy-MM-dd HH:mm:ss格式输出字符串
	public String getTime(){
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=date.format(new Date());
		return time;
	}
}


