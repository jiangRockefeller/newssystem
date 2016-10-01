package com.bdqn.news.service.impl;

import java.util.List;

import com.bdqn.news.dao.CommentsDao;
import com.bdqn.news.dao.impl.CommentsDaoImpl;
import com.bdqn.news.entity.Comments;
import com.bdqn.news.service.CommentsService;


public class CommentsServiceImpl implements CommentsService{
		CommentsDao comments=new CommentsDaoImpl();
	public List<Comments> getCommentByNid(int cnid) {
		// TODO Auto-generated method stub
		return comments.getCommentByNid(cnid);
	}

	public void addComments(int cnid,String cContent,String cDate,String cIP,String cAuthor) {
		// TODO Auto-generated method stub
		comments.addComments(cnid, cContent, cDate, cIP, cAuthor);
	}

}
