package com.lingo.profiles.bean;

import java.util.Date;

public class Education {
	private int id;
	private int pid;
	private String title;
	private String period;
	private String professional;
	private String link;
	private String intro;
	private Date addDate;
	private Date updateDate;
	
	public Education(int id, int pid, String title, String period,
			String professional, String link, String intro) {
		this(pid,title,period,professional,link,intro);
		this.id = id;
	}
	public Education(int pid, String title, String period, String professional,
			String link, String intro) {
		super();
		this.pid = pid;
		this.title = title;
		this.period = period;
		this.professional = professional;
		this.link = link;
		this.intro = intro;
	}
	
	public Education(){}
	
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
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
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
