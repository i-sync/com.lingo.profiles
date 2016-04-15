package com.lingo.profiles.controller;

import org.springframework.stereotype.Controller;
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
	
}
