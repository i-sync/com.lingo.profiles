package com.lingo.profiles.bean;

public class Project {
	private int id ;
	private int pid;
	private String title;
	private byte[] image;
	private String link;
	private String tags;
	private String intro;
		
	public Project(int id, int pid, String title, byte[] image, String link,
			String tags, String intro) {
		this(pid, title, image, link, tags, intro);
		this.id = id;
	}
	public Project(int pid, String title, byte[] image, String link,
			String tags, String intro) {
		super();
		this.pid = pid;
		this.title = title;
		this.image = image;
		this.link = link;
		this.tags = tags;
		this.intro = intro;
	}
	public Project(){}
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	
}
