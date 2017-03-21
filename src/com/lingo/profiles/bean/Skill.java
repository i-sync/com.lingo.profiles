package com.lingo.profiles.bean;

import java.util.Date;

public class Skill {
	private int id;
	private int pid;
	private int scid;
	private String title;
	private String content;
	private Date addDate;
	private Date updateDate;
	
	public Skill(int id,int pid,int scid, String title, String content)
	{
		this(pid,scid,title,content);
		this.id = id;
	}
	
	public Skill(int pid,int scid, String title, String content) {
		super();
		this.pid = pid;
		this.scid = scid;
		this.title = title;
		this.content = content;
	}
	public Skill(){}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getScid() {
		return scid;
	}

	public void setScid(int scid) {
		this.scid = scid;
	}
	
}
