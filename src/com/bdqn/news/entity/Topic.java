package com.bdqn.news.entity;

public class Topic {
	private int tid;
	private String tName;

	public Topic() {
	}

	public Topic(int tid, String tName) {
		super();
		this.tid = tid;
		this.tName = tName;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

}
