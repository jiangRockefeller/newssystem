package com.bdqn.news.service;

import java.util.List;

import com.bdqn.news.entity.News;

public interface NewsService {
	public List<News> getNewsTiltle(int ntid);

	public List<News> getPagingNewsTitleByTopic(int ntid, int pageNum,
			int pageSize);

	public int getMaxPage(int ntid, int pageSize);

	public List<News> getAllNewsTitle();
	public void deleteNewsByID(int nid);
	public void addNews(int ntid,String nTitle,String nAuthor,String nSummary,String nContent,String nPicPath,String nCreatDate);
	public News getNewsByNid(int nid);
	public void modifyNews(int nid,int ntid,String nTitle,String nAuthor,String nSummary,String nContent,String nPicPath,String nCreatDate);
}
