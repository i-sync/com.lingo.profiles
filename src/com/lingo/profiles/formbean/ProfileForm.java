package com.lingo.profiles.formbean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;

import com.lingo.profiles.bean.Education;
import com.lingo.profiles.bean.Link;
import com.lingo.profiles.bean.Living;
import com.lingo.profiles.bean.Project;
import com.lingo.profiles.bean.Skill;

public class ProfileForm {
	private int id;
	private String name;
	private byte[] avatar;
	private String email;
	private String phone;
	private String address;
	private String intro;
	private List<Skill> skill;
	private List<Project> project;
	private List<Education> education;
	private List<Link> link;
	private List<Living> living;
	private Map<String,String> errors = new HashMap<String,String>();
	
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
	public List<Skill> getSkill() {
		return skill;
	}
	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}
	public List<Project> getProject() {
		return project;
	}
	public void setProject(List<Project> project) {
		this.project = project;
	}
	public List<Education> getEducation() {
		return education;
	}
	public void setEducation(List<Education> education) {
		this.education = education;
	}
	public List<Link> getLink() {
		return link;
	}
	public void setLink(List<Link> link) {
		this.link = link;
	}
	public List<Living> getLiving() {
		return living;
	}
	public void setLiving(List<Living> living) {
		this.living = living;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
}
