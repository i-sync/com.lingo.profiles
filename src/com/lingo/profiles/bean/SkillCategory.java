package com.lingo.profiles.bean;

import java.util.Date;

public class SkillCategory {

	private int id;
	private int pid;
	private String title;
	private Date addDate;
	private Date updateDate;
	
	public SkillCategory(int id,int pid, String title)
	{
		this(pid,title);
		this.id = id;
	}
	
	public SkillCategory(int pid, String title) {
		super();
		this.pid = pid;
		this.title = title;
	}
	public SkillCategory(){}

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
}
