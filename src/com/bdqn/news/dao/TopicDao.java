package com.bdqn.news.dao;

import java.util.List;

import com.bdqn.news.entity.Topic;

public interface TopicDao {
	//��ȡtopic��
	public List<Topic> getTopic(String tag);
	//ɾ��topic
	public void delTopic(int tid);
	//�������
	public void addTopic(String tName);
	//ͨ��TID�޸�����
	public void modifyTopic(int tid,String tName);
}

