package com.lingo.profiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"/"})
public class ManageController {
	
	@RequestMapping(value={"/manage"})
	public String manage()
	{
		return "manage";
	}	
	
}
