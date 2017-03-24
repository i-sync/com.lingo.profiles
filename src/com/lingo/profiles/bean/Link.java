package com.lingo.profiles.bean;

import java.util.Date;

public class Link {
	private int id;
	private int pid;
	private String title;
	private String icon;
	private String link;
	private String logo;
	private Date addDate;
	private Date updateDate;
	
	public Link(int id, int pid, String title,String icon, String link, String logo) {
		this(pid,title,icon,link,logo);
		this.id = id;
	}
	public Link(int pid, String title, String icon, String link, String logo) {
		super();
		this.pid = pid;
		this.title = title;
		this.icon = icon;
		this.link = link;
		this.logo = logo;
	}
	public Link(){}
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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
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
