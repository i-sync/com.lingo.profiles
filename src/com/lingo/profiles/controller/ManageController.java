package com.lingo.profiles.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingo.profiles.bean.Login;

@Controller
@RequestMapping(value={"/"})
public class ManageController {
	
	@Login
	@RequestMapping(value={"/manage"})
	public String manage()
	{
		return "manage";
	}	
	@ModelAttribute(value="colors")
	public String[] getColor()
	{
		String [] colors =new String [] {"red","orange","yellow","olive","green","teal","blue","violet","purple","pink"};
		return colors;
	}
	
	@ModelAttribute(value="id")
	public int getProfileId(HttpServletRequest request)
	{
		return com.lingo.profiles.common.Common.getPid(request);
	}
}
