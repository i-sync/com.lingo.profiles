package com.lingo.profiles.bean;

import java.awt.Image;

public class Profile {
	private int id;
	private String name;
	private Image avater;
	private String email;
	private String phone;
	private String address;
	private String intro;
	
	public Profile(String name,Image avater, String email,String phone,String address,String intro)
	{
		this.name= name;
		this.avater = avater;
		this.email = email;
		this.phone = phone;
		this.address = address ;
		this.intro = intro;
	}
	public Profile(int id,String name,Image avater, String email,String phone,String address,String intro)
	{
		this(name,avater,email,phone,address,intro);
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Image getAvater() {
		return avater;
	}
	public void setAvater(Image avater) {
		this.avater = avater;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
}
