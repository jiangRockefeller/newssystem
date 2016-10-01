package com.bdqn.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.news.dao.DbConnect;
import com.bdqn.news.dao.NewsDao;
import com.bdqn.news.entity.News;

public class NewsDaoImpl extends DbConnect implements NewsDao {
	//以主题ntid获取新闻
	public List<News> getNewsByTopic(int ntid) {
		// TODO Auto-generated method stub
		List<News> list = new ArrayList<News>();
		Connection conn = this.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from news where ntid=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ntid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setNid(rs.getInt("NID"));
				news.setNtid(rs.getInt("NTID"));
				news.setnTitle(rs.getString("NTITLE"));
				news.setnAuthor(rs.getString("NAUTHOR"));
				news.setnCreatDate(rs.getString("NCREATEDATE"));
				news.setnPicpath(rs.getString("NPICPATH"));
				news.setnContent(rs.getString("NCONTENT"));
				news.setnModifyDate(rs.getDate("NMODIFYDATE"));
				news.setnModifyDate(rs.getDate("NMODIFYDATE"));
				news.setnSummary(rs.getString("NSUMMARY"));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}
	//新闻按主题分页
	public List<News> getPagingNewsTitleByTopic(int ntid, int pageNum,
			int pageSize) {
		// TODO Auto-generated method stub
		Connection conn = this.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT nid,Ntitle,NCREATEDATE from news WHERE NTID=? ORDER BY NCREATEDATE DESC LIMIT ?,?";
		List<News> list = new ArrayList<News>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ntid);
			pstmt.setInt(2, (pageNum - 1) * pageSize);
			pstmt.setInt(3, pageSize);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setNid(rs.getInt("nid"));
				news.setnTitle(rs.getString("NTITLE"));
				news.setnCreatDate(rs.getString("NCREATEDATE"));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}
	//获取所有新闻
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		List<News> list = new ArrayList<News>();
		Connection conn = this.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from news order by NCREATEDATE DESC";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setNid(rs.getInt("NID"));
				news.setNtid(rs.getInt("NTID"));
				news.setnTitle(rs.getString("NTITLE"));
				news.setnAuthor(rs.getString("NAUTHOR"));
				news.setnCreatDate(rs.getString("NCREATEDATE"));
				news.setnPicpath(rs.getString("NPICPATH"));
				news.setnContent(rs.getString("NCONTENT"));
				news.setnModifyDate(rs.getDate("NMODIFYDATE"));
				news.setnModifyDate(rs.getDate("NMODIFYDATE"));
				news.setnSummary(rs.getString("NSUMMARY"));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}
	//以新闻id删除新闻
	public void deleteNewsByID(int nid) {
		// TODO Auto-generated method stub
		Connection conn = this.getConnection();
		//先删除外键子表数据
		PreparedStatement fkpstmt = null;
		String fksql="delete from comments where CNID=?";
		try {
			fkpstmt=conn.prepareStatement(fksql);
			fkpstmt.setInt(1, nid);
			fkpstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		//再删news表数据
		PreparedStatement pstmt = null;
		String sql="delete from news where nid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, nid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			ResultSet rs=null;
			this.closeAll(conn, pstmt, rs);
		}
	}
	//添加新闻
	public void addNews(int ntid, String nTitle, String nAuthor,
			String nSummary, String nContent, String nPicPath,String nCreatDate) {
		// TODO Auto-generated method stub
		Connection conn=this.getConnection();
		PreparedStatement pstmt=null;
		String sql="insert into news(NTID,NTITLE,NAUTHOR,NSUMMARY,NCONTENT,NPICPATH,NCREATEDATE) values(?,?,?,?,?,?,?)";
		if (nCreatDate=="") {
			nCreatDate=this.getTime();
		}
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ntid);
			pstmt.setString(2, nTitle);
			pstmt.setString(3, nAuthor);
			pstmt.setString(4, nSummary);
			pstmt.setString(5, nContent);
			pstmt.setString(6, nPicPath);
			pstmt.setString(7, nCreatDate);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ResultSet rs=null;
			this.closeAll(conn, pstmt, rs);
		}
	}
	//以新闻ID获取新闻
	public News getNewsByNid(int nid) {
		// TODO Auto-generated method stub
		Connection conn=this.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from news where nid=?";
		News news=new News();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, nid);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				News instance=new News();
				instance.setNid(rs.getInt("NID"));
				instance.setNtid(rs.getInt("NTID"));
				instance.setnTitle(rs.getString("NTITLE"));
				instance.setnAuthor(rs.getString("NAUTHOR"));
				instance.setnCreatDate(rs.getString("NCREATEDATE"));
				instance.setnPicpath(rs.getString("NPICPATH"));
				instance.setnContent(rs.getString("NCONTENT"));
				instance.setnModifyDate(rs.getDate("NMODIFYDATE"));
				instance.setnModifyDate(rs.getDate("NMODIFYDATE"));
				instance.setnSummary(rs.getString("NSUMMARY"));
				news=instance;
			}
			return news;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return null;
	}
	//修改新闻
	public void modifyNews(int nid,int ntid, String nTitle, String nAuthor,
			String nSummary, String nContent, String nPicPath, String nCreatDate) {
		// TODO Auto-generated method stub
		Connection conn=this.getConnection();
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		if(nCreatDate==""){
			nCreatDate=this.getTime();
		}
		String sql="update news set ntid=?,nTitle=?,nAuthor=?,nSummary=?,nContent=?,nPicPath=?,nCreateDate=?,NMODIFYDATE=? where nid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ntid);
			pstmt.setString(2, nTitle);
			pstmt.setString(3, nAuthor);
			pstmt.setString(4, nSummary);
			pstmt.setString(5, nContent);
			pstmt.setString(6, nPicPath);
			pstmt.setString(7, nCreatDate);
			pstmt.setString(8, nCreatDate);
			pstmt.setInt(9, nid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		
		
	}

}
