package com.lingo.profiles.formbean;

import java.util.HashMap;
import java.util.Map;

public class EducationForm {
	private int id;
	private int pid;
	private String title;
	private String logo;
	private String period;
	private String professional;
	private String link;
	private String intro;
	private Map<String,String> errors = new HashMap<String,String>();
	
	public EducationForm(int id, int pid, String title, String logo, String period,
			String professional, String link, String intro) {
		this(pid,title,logo,period,professional,link,intro);
		this.id = id;
	}
	public EducationForm(int pid, String title, String logo, String period, String professional,
			String link, String intro) {
		super();
		this.pid = pid;
		this.title = title;
		this.logo = logo;
		this.period = period;
		this.professional = professional;
		this.link = link;
		this.intro = intro;
	}
	
	public EducationForm(){}
	
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
		if(this.period ==null || this.period.trim().equals(""))
		{
			this.errors.put("period", "period can't is empty");
			flag = false;
		}
		if(this.professional ==null || this.professional.trim().equals(""))
		{
			this.errors.put("professional", "professional can't is empty");
			flag = false;
		}
		/*if(this.link ==null || this.link.trim().equals(""))
		{
			this.errors.put("link", "link can't is empty");
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
