package com.lingo.profiles.formbean;

import java.util.HashMap;
import java.util.Map;

public class SkillForm {
	private int id;
	private int pid;
	private int scid;
	private String sctitle;
	private String title;
	private String content;
	private Map<String,String> errors = new HashMap<String,String>();
	
	public SkillForm(int id,int pid, int scid, String title, String content)
	{
		this(pid,scid,title,content);
		this.id = id;
	}
	
	public SkillForm(int pid,int scid, String title, String content) {
		super();
		this.pid = pid;
		this.scid = scid;
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
		if(this.scid == 0)
		{
			this.errors.put("scid", "please select skill category");
			flag = false;
		}
		if(this.title ==null ||this.title.trim().equals(""))
		{
			this.errors.put("title", "title can't is empty");
			flag =false;
		}
		if(this.content ==null || this.content.trim().equals(""))
		{
			this.errors.put("content", "content can't is empty");
			flag = false;
		}

		return flag;
	}

	public int getScid() {
		return scid;
	}

	public void setScid(int scid) {
		this.scid = scid;
	}

	public String getSctitle() {
		return sctitle;
	}

	public void setSctitle(String scTitle) {
		this.sctitle = scTitle;
	}
}
