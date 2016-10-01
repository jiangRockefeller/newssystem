package com.bdqn.news.entity;

import java.sql.Date;

public class News {
	private int nid;
	private int ntid;
	private String nTitle;
	private String nAuthor;
	private String nCreatDate;
	private Date nModifyDate;
	private String nPicPath;
	private String nContent;
	private String nSummary;

	public News() {
	}

	public News(int nid, int ntid, String nTitle, String nAuthor,
			String nCreatDate, Date nModifyDate, String nPicPath,
			String nContent, String nSummary) {
		super();
		this.nid = nid;
		this.ntid = ntid;
		this.nTitle = nTitle;
		this.nAuthor = nAuthor;
		this.nCreatDate = nCreatDate;
		this.nModifyDate = nModifyDate;
		this.nPicPath = nPicPath;
		this.nContent = nContent;
		this.nSummary = nSummary;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public int getNtid() {
		return ntid;
	}

	public void setNtid(int ntid) {
		this.ntid = ntid;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnAuthor() {
		return nAuthor;
	}

	public void setnAuthor(String nAuthor) {
		this.nAuthor = nAuthor;
	}

	public String getnCreatDate() {
		return nCreatDate;
	}

	public void setnCreatDate(String nCreatDate) {
		this.nCreatDate = nCreatDate;
	}

	public Date getnModifyDate() {
		return nModifyDate;
	}

	public void setnModifyDate(Date nModifyDate) {
		this.nModifyDate = nModifyDate;
	}

	public String getnPicpath() {
		return nPicPath;
	}

	public void setnPicpath(String nPicpath) {
		this.nPicPath = nPicpath;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public String getnSummary() {
		return nSummary;
	}

	public void setnSummary(String nSummary) {
		this.nSummary = nSummary;
	}

}
