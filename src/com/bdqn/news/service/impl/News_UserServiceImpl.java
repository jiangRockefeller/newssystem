package com.bdqn.news.service.impl;

import java.util.List;

import com.bdqn.news.dao.News_UserDao;
import com.bdqn.news.dao.impl.News_UserDaoImpl;
import com.bdqn.news.entity.News_Users;
import com.bdqn.news.service.News_UserService;

public class News_UserServiceImpl implements News_UserService{
	News_UserDao userDao=new News_UserDaoImpl();
	
	public boolean login(String uname,String upwd) {
		// TODO Auto-generated method stub
		 String password=userDao.login(uname);
		 System.out.println("News_UserServiceImplÓÃ»§:"+uname+"\t³¢ÊÔµÇÂ¼");
		if (uname!=""&&upwd!=""&&password!=""&&password.equals(upwd)) {
			System.out.println("News_UserServiceImpl:µÇÂ¼³É¹¦");
			return true;
		}
		System.out.println("News_UserServiceImpl:µÇÂ¼Ê§°Ü");
		return false;
	}

	public List<News_Users> getAllUserByPageNum(int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		
		return userDao.getAllUserByPageNum(pageNum,pageSize);
	}





	public int getMaxPage(int pageSize) {
		// TODO Auto-generated method stub
		int maxPage=0;
		int page=userDao.getAllUsers().size();
		if(page%pageSize==0){
			maxPage=page/pageSize;
		}
		else{
			maxPage=page/pageSize+1;
		}
		return maxPage;
	}
	
}
