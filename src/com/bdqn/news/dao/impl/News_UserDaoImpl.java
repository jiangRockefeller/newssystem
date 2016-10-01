package com.bdqn.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.news.dao.DbConnect;
import com.bdqn.news.dao.News_UserDao;
import com.bdqn.news.entity.News_Users;

public class News_UserDaoImpl extends DbConnect implements News_UserDao {
	// ÓÃ»§µÇÂ¼
	public String login(String uname) {
		// TODO Auto-generated method stub
		Connection conn = this.getConnection();
		String sql = "select upwd from news_users where uname=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String password = "";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				password = rs.getString("upwd");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closeAll(conn, pstmt, rs);
		return password;
	}
	//·ÖÒ³
	public List<News_Users> getAllUserByPageNum(int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		Connection conn=this.getConnection();
		List<News_Users> list=new ArrayList<News_Users>();
		String sql="select * from NEWS_USERS LIMIT ?,?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNum-1)*pageSize);
			pstmt.setInt(2, pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()){
				News_Users users=new News_Users();
				users.setUname(rs.getString("uname"));
				list.add(users);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		
		return list;
	}
	public List<News_Users> getAllUsers() {
		// TODO Auto-generated method stub
		Connection conn=this.getConnection();
		List<News_Users> list=new ArrayList<News_Users>();
		String sql="select * from NEWS_USERS";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);

			rs=pstmt.executeQuery();
			while(rs.next()){
				News_Users users=new News_Users();
				users.setUname(rs.getString("uname"));
				list.add(users);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		
		return list;
	}


}
