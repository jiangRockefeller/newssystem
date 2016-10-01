package com.bdqn.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.news.dao.CommentsDao;
import com.bdqn.news.dao.DbConnect;
import com.bdqn.news.entity.Comments;

public class CommentsDaoImpl extends DbConnect implements CommentsDao {

	public List<Comments> getCommentByNid(int cnid) {
		// TODO Auto-generated method stub
		Connection conn=this.getConnection();
		List<Comments> comments=new ArrayList<Comments>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from comments where cnid=? order by cDate DESC";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cnid);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				Comments instance=new Comments();
				instance.setcAuthor(rs.getString("cAuthor"));
				instance.setcContent(rs.getString("cContent"));
				instance.setcDate(rs.getString("cDate"));
				//instance.setCid(rs.getInt("Cid"));
				instance.setCIP(rs.getString("CIP"));
				instance.setCnid(rs.getInt("Cnid"));
				comments.add(instance);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		
		return comments;
	}

	public void addComments(int cnid,String cContent,String cDate,String cIP,String cAuthor) {
		// TODO Auto-generated method stub
		Connection conn=this.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="insert into comments(cnid,cContent,cDate,cIP,cAuthor) values(?,?,?,?,?)";
		if (cDate=="") {
			cDate=this.getTime();
		}
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cnid);
			pstmt.setString(2, cContent);
			pstmt.setString(3, cDate);
			pstmt.setString(4, cIP);
			pstmt.setString(5, cAuthor);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		
	}

	


}
