package com.bdqn.news.dao;

import java.util.List;

import com.bdqn.news.entity.News_Users;

public interface News_UserDao {
	/*
	 * 用户登录
	 */
	public String login(String name);
	
	/*
	 * 获取所有用户的用户名-->通过list.size获得用户数量
	 */
	public List<News_Users> getAllUsers();
	
	/*
	 * 分页获取获取user表的用户名
	 * 传入页码pageNum,和每页显示的行数pageSize
	 */
	public List<News_Users>getAllUserByPageNum(int pageNum,int pageSize);
	
}
