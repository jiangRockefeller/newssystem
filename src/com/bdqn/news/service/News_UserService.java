package com.bdqn.news.service;

import java.util.List;

import com.bdqn.news.entity.News_Users;

public interface News_UserService {
	//用户登录
	public boolean login(String uname,String upwd);

	 
	//获取用户分页数

	public int getMaxPage(int pageSize);
	
	/*
	 * 获取所有用户(分页)
	 * 需要参数pageNum
	 */
	public List<News_Users>getAllUserByPageNum(int pageNum,int pageSize);
	
	
}
