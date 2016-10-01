package com.bdqn.news.dao;

import java.util.List;

import com.bdqn.news.entity.Comments;

public interface CommentsDao {
	//根据新闻id获取评论
	public List<Comments> getCommentByNid(int cnid); 
	//添加评论
	public void addComments(int cnid,String cContent,String cDate,String cIP,String cAuthor);
}
