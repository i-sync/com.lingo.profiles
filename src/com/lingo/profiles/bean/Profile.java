package com.lingo.profiles.bean;

import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

public class Profile {
	private int id;
	private String name;
	private String nickName;
	private String avatar;
	private String email;
	private String phone;
	private String address;
	private String profession;
	private String intro;
	private Date addDate;
	private Date updateDate;
	private List<Skill> skill;
	private List<SkillCategory> skillCategory;
	private List<Experience> experience;
	private List<Project> project;
	private List<Education> education;
	private List<Link> link;
	private List<Living> living;
	
	public Profile(String name,String avatar, String email,String phone,String address,String profession, String intro)
	{
		this.name= name;
		this.avatar = avatar;
		this.email = email;
		this.phone = phone;
		this.address = address ;
		this.profession = profession;
		this.intro = intro;
	}
	public Profile(int id,String name,String avatar, String email,String phone,String address,String profession, String intro)
	{
		this(name,avatar,email,phone,address,profession,intro);
		this.id = id;
	}
	
	public Profile(){}
	
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
	
	public String getNickName()
	{
		return this.nickName;
	}
	public void setNickName(String nickName)
	{
		this.nickName=nickName;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
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
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public List<Skill> getSkill() {
		return skill;
	}
	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}
	public List<Experience> getExperience() {
		return experience;
	}
	public void setExperience(List<Experience> experience) {
		this.experience = experience;
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
	public List<SkillCategory> getSkillCategory() {
		return skillCategory;
	}
	public void setSkillCategory(List<SkillCategory> skillCategory) {
		this.skillCategory = skillCategory;
	}
	
}
