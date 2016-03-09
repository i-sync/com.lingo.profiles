package com.lingo.profiles.formbean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;

import com.lingo.profiles.utils.RegexUtil;

public class ProfileForm {
	private int id;
	private String name;
	private String nickName;
	private byte[] avatar;
	private String email;
	private String phone;
	private String address;
	private String intro;
	private List<SkillForm> skill;
	private List<ExperienceForm> experience;
	private List<ProjectForm> project;
	private List<EducationForm> education;
	private List<LinkForm> link;
	private List<LivingForm> living;
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
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	
	public List<SkillForm> getSkill() {
		return skill;
	}
	public void setSkill(List<SkillForm> skill) {
		this.skill = skill;
	}
	public List<ExperienceForm> getExperience() {
		return experience;
	}
	public void setExperience(List<ExperienceForm> experience) {
		this.experience = experience;
	}
	public List<ProjectForm> getProject() {
		return project;
	}
	public void setProject(List<ProjectForm> project) {
		this.project = project;
	}
	public List<EducationForm> getEducation() {
		return education;
	}
	public void setEducation(List<EducationForm> education) {
		this.education = education;
	}
	public List<LinkForm> getLink() {
		return link;
	}
	public void setLink(List<LinkForm> link) {
		this.link = link;
	}
	public List<LivingForm> getLiving() {
		return living;
	}
	public void setLiving(List<LivingForm> living) {
		this.living = living;
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
		if(this.name ==null ||this.name.trim().equals(""))
		{
			this.errors.put("name", "name can't is empty");
			flag =false;
		}
		if(this.phone ==null || this.name.trim().equals(""))
		{
			this.errors.put("name", "name can't is empty");
			flag = false;
		}
		else//validate format.
		{
			if (!RegexUtil.isMobile(this.phone)) {
				flag = false;
				this.errors.put("phone", "please input correct phone number!");
			}
		}
		if(this.email ==null ||this.email.trim().equals(""))
		{
			this.errors.put("email", "email can't is empty");
			flag =false;
		}
		else //validate format
		{
			if (!RegexUtil.isEmail(this.email)) {
				flag = false;
				this.errors.put("email", "please input correct email!");
			}
		}
		if(this.address ==null || this.address.trim().equals(""))
		{
			this.errors.put("address", "address can't is empty");
			flag = false;
		}
		if(this.intro ==null ||this.intro.trim().equals(""))
		{
			this.errors.put("intro", "intro can't is empty");
			flag =false;
		}
		return flag;
	}
}
