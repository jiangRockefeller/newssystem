package com.bdqn.news.service.impl;

import java.util.List;

import com.bdqn.news.dao.NewsDao;
import com.bdqn.news.dao.impl.NewsDaoImpl;
import com.bdqn.news.entity.News;
import com.bdqn.news.service.NewsService;
public class NewsServiceImpl implements NewsService{
		NewsDao news= new NewsDaoImpl();
		//----------按分类获取标题
	public List<News> getNewsTiltle(int ntid) {
		// TODO Auto-generated method stub
		List<News> newsList=news.getNewsByTopic(ntid);
		return newsList;
	}
		//----------主页新闻分页
	public List<News> getPagingNewsTitleByTopic(int ntid, int pageNum,
			int pageSize) {
		return news.getPagingNewsTitleByTopic(ntid, pageNum, pageSize);
	}
		//----------主页分页获取最大页数
	public int getMaxPage(int ntid,int pageSize) {
		// TODO Auto-generated method stub
		int listSize=news.getNewsByTopic(ntid).size();
		int MaxPage=0;
		if(listSize%pageSize==0){
			MaxPage=listSize/pageSize;
		}
		else{
			MaxPage=listSize/pageSize+1;
		}
		return MaxPage;
	}
		//----------返回所有新闻标题
	public List<News> getAllNewsTitle() {
		// TODO Auto-generated method stub
		List<News> list=news.getAllNews();
		return list;
	}
		//----------按ID删除新闻
	public void deleteNewsByID(int nid) {
		// TODO Auto-generated method stub
		news.deleteNewsByID(nid);
	}
		//----------添加新闻
	public void addNews(int ntid, String nTitle, String nAuthor,
			String nSummary, String nContent, String nPicPath, String nCreatDate) {
		// TODO Auto-generated method stub
		news.addNews(ntid, nTitle, nAuthor, nSummary, nContent, nPicPath, nCreatDate);
	}
	public News getNewsByNid(int nid) {
		// TODO Auto-generated method stub
		return news.getNewsByNid(nid);
	}
	public void modifyNews(int nid,int ntid, String nTitle, String nAuthor,
			String nSummary, String nContent, String nPicPath, String nCreatDate) {
		// TODO Auto-generated method stub
		news.modifyNews(nid,ntid, nTitle, nAuthor, nSummary, nContent, nPicPath, nCreatDate);
	}
}
