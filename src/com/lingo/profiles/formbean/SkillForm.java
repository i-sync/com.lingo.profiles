package com.lingo.profiles.formbean;

public class SkillForm {
	private int id;
	private int pid;
	private String title;
	private String content;
	
	public SkillForm(int id,int pid, String title, String content)
	{
		this(pid,title,content);
		this.id = id;
	}
	
	public SkillForm(int pid, String title, String content) {
		super();
		this.pid = pid;
		this.title = title;
		this.content = content;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
