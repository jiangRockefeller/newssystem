package com.bdqn.news.service;

import java.util.List;

import com.bdqn.news.entity.Comments;

public interface CommentsService {
		//根据新闻id获取评论
		public List<Comments> getCommentByNid(int cnid); 
		//添加评论
		public void addComments(int cnid,String cContent,String cDate,String cIP,String cAuthor);
}
