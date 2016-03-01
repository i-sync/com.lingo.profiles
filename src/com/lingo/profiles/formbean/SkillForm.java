package com.lingo.profiles.formbean;

import java.util.HashMap;
import java.util.Map;

public class SkillForm {
	private int id;
	private int pid;
	private String title;
	private String content;
	private Map<String,String> errors = new HashMap<String,String>();
	
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
	public SkillForm(){}

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

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	/**
	 * verify
	 * @return
	 */
	public boolean validate() {
		boolean flag = true;
		if(this.title ==null ||this.title.trim().equals(""))
		{
			this.errors.put("title", "title can't is empty");
			flag =false;
		}
		if(this.content ==null || this.content.trim().equals(""))
		{
			this.errors.put("vocational", "content can't is empty");
			flag = false;
		}

		return flag;
	}
}
