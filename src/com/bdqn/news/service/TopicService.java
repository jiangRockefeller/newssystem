package com.bdqn.news.service;

import java.util.List;

import com.bdqn.news.entity.Topic;

public interface TopicService {
	public List<Topic> getTopic(String tag);
	public void delTopic(int tid);
	public void addTopic(String tName);
	public void modifyTopic(int tid,String tName);
}
