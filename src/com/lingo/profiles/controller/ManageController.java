package com.lingo.profiles.controller;

import java.util.ArrayList;
import java.util.List;

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
}
