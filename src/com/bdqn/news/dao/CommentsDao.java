package com.bdqn.news.dao;

import java.util.List;

import com.bdqn.news.entity.Comments;

public interface CommentsDao {
	//��������id��ȡ����
	public List<Comments> getCommentByNid(int cnid); 
	//�������
	public void addComments(int cnid,String cContent,String cDate,String cIP,String cAuthor);
}
