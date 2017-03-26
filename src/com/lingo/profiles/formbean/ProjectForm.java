package com.lingo.profiles.formbean;

import java.util.HashMap;
import java.util.Map;


public class ProjectForm {
	private int id ;
	private int pid;
	private String title;
	private String image;
	private String link;
	private String tags;
	private String intro;
	private Map<String,String> errors = new HashMap<String,String>();
		
	public ProjectForm(int id, int pid, String title, String image, String link,
			String tags, String intro) {
		this(pid, title, image, link, tags, intro);
		this.id = id;
	}
	public ProjectForm(int pid, String title, String image, String link,
			String tags, String intro) {
		super();
		this.pid = pid;
		this.title = title;
		this.image = image;
		this.link = link;
		this.tags = tags;
		this.intro = intro;
	}
	public ProjectForm(){}
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
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
		if(this.tags ==null || this.tags.trim().equals(""))
		{
			this.errors.put("tags", "tags can't is empty");
			flag = false;
		}
		/*if(this.link ==null ||this.link.trim().equals(""))
		{
			this.errors.put("link", "link can't is empty");
			flag =false;
		}*/
		if(this.intro ==null || this.intro.trim().equals(""))
		{
			this.errors.put("intro", "intro can't is empty");
			flag = false;
		}

		return flag;
	}
}
