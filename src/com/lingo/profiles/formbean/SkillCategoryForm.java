package com.lingo.profiles.formbean;

import java.util.HashMap;
import java.util.Map;

public class SkillCategoryForm {
	private int id;
	private int pid;
	private String title;
	private Map<String,String> errors = new HashMap<String,String>();
	
	public SkillCategoryForm(int id,int pid, String title)
	{
		this(pid,title);
		this.id = id;
	}
	
	public SkillCategoryForm(int pid, String title) {
		super();
		this.pid = pid;
		this.title = title;
	}
	public SkillCategoryForm(){}

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

		return flag;
	}
}
