package com.bdqn.news.dao;

import java.util.List;

import com.bdqn.news.entity.News;

public  interface NewsDao {
	//按ID查找新闻
	public News getNewsByNid(int nid);
	//按类型查找news表 select * from news where ntid=?
	public List<News> getNewsByTopic(int ntid);
	//按类型查找NEWS表并分页显示
	public List<News> getPagingNewsTitleByTopic(int ntid,int pageNum,int pageSize);
	//获取所有新闻
	public List<News> getAllNews();
	//删除新闻
	public void deleteNewsByID(int nid);
	//添加新闻
	public void addNews(int ntid,String nTitle,String nAuthor,String nSummary,String nContent,String nPicPath,String nCreatDate);
	//编辑新闻
	public void modifyNews(int nid,int ntid,String nTitle,String nAuthor,String nSummary,String nContent,String nPicPath,String nCreatDate);
}
