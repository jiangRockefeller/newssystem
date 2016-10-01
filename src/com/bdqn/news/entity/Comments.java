package com.bdqn.news.entity;

import java.sql.Date;

public class Comments {
	private int cid;
	private int cnid;
	private String cContent;
	private String cDate;
	private String CIP;
	private String cAuthor;
	public Comments(){}
	public Comments(int cid, int cnid, String cContent, String cDate, String cIP,
			String cAuthor) {
		super();
		this.cid = cid;
		this.cnid = cnid;
		this.cContent = cContent;
		this.cDate = cDate;
		this.CIP = cIP;
		this.cAuthor = cAuthor;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCnid() {
		return cnid;
	}
	public void setCnid(int cnid) {
		this.cnid = cnid;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public String getcDate() {
		return cDate;
	}
	public void setcDate(String cDate) {
		this.cDate = cDate;
	}
	public String getCIP() {
		return CIP;
	}
	public void setCIP(String cIP) {
		CIP = cIP;
	}
	public String getcAuthor() {
		return cAuthor;
	}
	public void setcAuthor(String cAuthor) {
		this.cAuthor = cAuthor;
	}
	
}
