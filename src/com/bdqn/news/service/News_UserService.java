package com.bdqn.news.service;

import java.util.List;

import com.bdqn.news.entity.News_Users;

public interface News_UserService {
	//�û���¼
	public boolean login(String uname,String upwd);

	 
	//��ȡ�û���ҳ��

	public int getMaxPage(int pageSize);
	
	/*
	 * ��ȡ�����û�(��ҳ)
	 * ��Ҫ����pageNum
	 */
	public List<News_Users>getAllUserByPageNum(int pageNum,int pageSize);
	
	
}
