package com.lingo.profiles.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;


public class LinkForm {
	private int id;
	private int pid;
	private String title;
	private String icon;
	private String link;
	private byte[] logo;
	private Map<String,String> errors = new HashMap<String,String>();
	
	public LinkForm(int id, int pid, String title, String icon, String link, byte[] logo) {
		this(pid,title,icon,link,logo);
		this.id = id;
	}
	public LinkForm(int pid, String title, String icon, String link, byte[] logo) {
		super();
		this.pid = pid;
		this.title = title;
		this.icon=icon;
		this.link = link;
		this.logo = logo;
	}
	public LinkForm(){}
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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
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
	public String getLogoImage()
	{
		return new Base64().encodeToString(this.logo);
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
		if(this.icon ==null ||this.icon.trim().equals(""))
		{
			this.errors.put("icon", "icon can't is empty");
			flag =false;
		}
		if(this.link ==null || this.link.trim().equals(""))
		{
			this.errors.put("link", "link can't is empty");
			flag = false;
		}

		return flag;
	}
}
