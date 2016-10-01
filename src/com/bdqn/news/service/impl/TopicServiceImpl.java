package com.bdqn.news.service.impl;

import java.util.List;

import com.bdqn.news.dao.TopicDao;
import com.bdqn.news.dao.impl.TopicDaoImpl;
import com.bdqn.news.entity.Topic;
import com.bdqn.news.service.TopicService;

public class TopicServiceImpl implements TopicService{
	TopicDao topic=new TopicDaoImpl();
	public List<Topic> getTopic(String tag) {
		// TODO Auto-generated method stub
		
		List<Topic> tNameList=topic.getTopic(tag);
		return tNameList;
	}

	public void delTopic(int tid) {
		// TODO Auto-generated method stub
		topic.delTopic(tid);
	}
	public void addTopic(String tName){
		topic.addTopic(tName);
	}

	public void modifyTopic(int tid, String tName) {
		// TODO Auto-generated method stub
		topic.modifyTopic(tid, tName);
	}

}
