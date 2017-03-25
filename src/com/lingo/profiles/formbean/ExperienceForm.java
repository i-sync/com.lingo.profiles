package com.lingo.profiles.formbean;

import java.util.HashMap;
import java.util.Map;

public class ExperienceForm {
	private int id;
	private int pid;
	private String title;
	private String logo;
	private String company;
	private String link;
	private String period;
	private String location;
	private String position;
	private String intro;
	private Map<String,String> errors = new HashMap<String,String>();

	public ExperienceForm(int id, int pid, String title,String logo, String company, String link, String period, String location,
			String position, String intro) {
		this(pid, title, logo, company, link, period, location, position, intro);
		this.id = id;
	}
	public ExperienceForm(int pid, String title, String logo, String company, String link, String period, String location, String position,
			String intro) {
		super();
		this.pid = pid;
		this.title = title;
		this.logo = logo;
		this.company = company;
		this.link = link;
		this.period = period;
		this.location = location;
		this.position = position;
		this.intro = intro;
	}
	public ExperienceForm(){}
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
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getPosition() {
		return position;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setPosition(String position) {
		this.position = position;
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
		/*if(this.title ==null ||this.title.trim().equals(""))
		{
			this.errors.put("title", "title can't is empty");
			flag =false;
		}*/
		if(this.company ==null || this.company.trim().equals(""))
		{
			this.errors.put("company", "company can't is empty");
			flag = false;
		}
		if(this.period ==null || this.period.trim().equals(""))
		{
			this.errors.put("period", "period can't is empty");
			flag = false;
		}
		if(this.position ==null || this.position.trim().equals(""))
		{
			this.errors.put("position", "position can't is empty");
			flag = false;
		}
		/*if(this.location ==null || this.location.trim().equals(""))
		{
			this.errors.put("location", "location can't is empty");
			flag = false;
		}*/
		if(this.intro ==null || this.intro.trim().equals(""))
		{
			this.errors.put("intro", "intro can't is empty");
			flag = false;
		}

		return flag;
	}
}
