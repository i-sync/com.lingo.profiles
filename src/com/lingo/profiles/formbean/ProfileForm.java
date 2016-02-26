package com.lingo.profiles.formbean;

import org.apache.tomcat.util.codec.binary.Base64;

public class ProfileForm {
	private int id;
	private String name;
	private byte[] avatar;
	private String email;
	private String phone;
	private String address;
	private String intro;
	
	public ProfileForm(String name,byte[] avatar, String email,String phone,String address,String intro)
	{
		this.name= name;
		this.avatar = avatar;
		this.email = email;
		this.phone = phone;
		this.address = address ;
		this.intro = intro;
	}
	public ProfileForm(int id,String name,byte[] avatar, String email,String phone,String address,String intro)
	{
		this(name,avatar,email,phone,address,intro);
		this.id = id;
	}
	public ProfileForm(){}
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
	public byte[] getAvatar() {
		return avatar;
	}
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}
	public String getAvatarImage()
	{
		return new Base64().encodeToString(this.avatar);
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
