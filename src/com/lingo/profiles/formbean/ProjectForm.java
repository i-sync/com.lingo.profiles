package com.lingo.profiles.formbean;

import org.apache.tomcat.util.codec.binary.Base64;

public class ProjectForm {
	private int id ;
	private int pid;
	private String title;
	private byte[] image;
	private String link;
	private String tags;
	private String intro;
		
	public ProjectForm(int id, int pid, String title, byte[] image, String link,
			String tags, String intro) {
		this(pid, title, image, link, tags, intro);
		this.id = id;
	}
	public ProjectForm(int pid, String title, byte[] image, String link,
			String tags, String intro) {
		super();
		this.pid = pid;
		this.title = title;
		this.image = image;
		this.link = link;
		this.tags = tags;
		this.intro = intro;
	}
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
	public String getProjectImage()
	{
		return new Base64().encodeToString(this.image);
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
