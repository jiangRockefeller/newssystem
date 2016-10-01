package com.bdqn.news.dao;

import java.util.List;

import com.bdqn.news.entity.News_Users;

public interface News_UserDao {
	/*
	 * �û���¼
	 */
	public String login(String name);
	
	/*
	 * ��ȡ�����û����û���-->ͨ��list.size����û�����
	 */
	public List<News_Users> getAllUsers();
	
	/*
	 * ��ҳ��ȡ��ȡuser����û���
	 * ����ҳ��pageNum,��ÿҳ��ʾ������pageSize
	 */
	public List<News_Users>getAllUserByPageNum(int pageNum,int pageSize);
	
}
