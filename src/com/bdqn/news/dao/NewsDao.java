package com.bdqn.news.dao;

import java.util.List;

import com.bdqn.news.entity.News;

public  interface NewsDao {
	//��ID��������
	public News getNewsByNid(int nid);
	//�����Ͳ���news�� select * from news where ntid=?
	public List<News> getNewsByTopic(int ntid);
	//�����Ͳ���NEWS����ҳ��ʾ
	public List<News> getPagingNewsTitleByTopic(int ntid,int pageNum,int pageSize);
	//��ȡ��������
	public List<News> getAllNews();
	//ɾ������
	public void deleteNewsByID(int nid);
	//�������
	public void addNews(int ntid,String nTitle,String nAuthor,String nSummary,String nContent,String nPicPath,String nCreatDate);
	//�༭����
	public void modifyNews(int nid,int ntid,String nTitle,String nAuthor,String nSummary,String nContent,String nPicPath,String nCreatDate);
}
