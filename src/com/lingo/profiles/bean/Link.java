package com.lingo.profiles.bean;


public class Link {
	private int id;
	private int pid;
	private String title;
	private String link;
	private byte[] logo;
	
	public Link(int id, int pid, String title, String link, byte[] logo) {
		this(pid,title,link,logo);
		this.id = id;
	}
	public Link(int pid, String title, String link, byte[] logo) {
		super();
		this.pid = pid;
		this.title = title;
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
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	
	
}
