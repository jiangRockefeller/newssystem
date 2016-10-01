package com.bdqn.news.dao;

import java.util.List;

import com.bdqn.news.entity.Topic;

public interface TopicDao {
	//获取topic表
	public List<Topic> getTopic(String tag);
	//删除topic
	public void delTopic(int tid);
	//添加主题
	public void addTopic(String tName);
	//通过TID修改主题
	public void modifyTopic(int tid,String tName);
}

