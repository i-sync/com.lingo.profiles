package com.lingo.profiles.bean;

public class Social {
	private int id;
	private String icon;
	private String name;
	private String bg;
	
	public Social(int id, String icon, String name, String bg) {
		super();
		this.id = id;
		this.icon = icon;
		this.name = name;
		this.bg = bg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBg() {
		return bg;
	}
	public void setBg(String bg) {
		this.bg = bg;
	}
	
}
