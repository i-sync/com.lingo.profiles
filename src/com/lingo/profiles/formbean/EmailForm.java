package com.lingo.profiles.formbean;

import java.util.HashMap;
import java.util.Map;

import com.lingo.profiles.utils.RegexUtil;

public class EmailForm {
	
	private Boolean result;
	private String name;
	private String email;
	private String subject;
	private String message;
	private Map<String,String> errors = new HashMap<String,String>();
	public EmailForm(String name, String email, String subject, String message) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}
	
	public EmailForm(){}

	
	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
		/*
		if(this.subject ==null ||this.subject.trim().equals(""))
		{
			this.errors.put("subject", "subject can't is empty");
			flag =false;
		}
		*/
		if(this.message ==null || this.message.trim().equals(""))
		{
			this.errors.put("message", "message can't is empty");
			flag = false;
		}
		result = flag;
		return flag;
	}
}
