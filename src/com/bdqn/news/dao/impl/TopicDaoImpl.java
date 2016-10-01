package com.bdqn.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.news.dao.DbConnect;
import com.bdqn.news.dao.TopicDao;
import com.bdqn.news.entity.Topic;


public class TopicDaoImpl extends DbConnect implements TopicDao{
	public List<Topic> getTopic(String tag) {
		// TODO Auto-generated method stub
		List<Topic> list=new ArrayList<Topic>();
		Connection conn=this.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select "+tag+" from topic";
		try {
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			while (rs.next()) {
				Topic topic=new Topic();
				if (tag.equals("*")||tag.contains("TID")) {
					topic.setTid(rs.getInt("TID"));
				}
				topic.settName(rs.getString("TNAME"));
				list.add(topic);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		
		return list;
	}

	public void delTopic(int tid) {
		// TODO Auto-generated method stub
		Connection conn=this.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="delete from topic where tid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, tid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		
	}

	public void addTopic(String tName) {
		// TODO Auto-generated method stub
		Connection conn=this.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="insert into topic(TNAME) values(?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, tName);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		
	}

	public void modifyTopic(int tid,String tName) {
		// TODO Auto-generated method stub
		Connection conn=this.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="update topic set TNAME=? where TID=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, tName);
			pstmt.setInt(2, tid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
	}

}
