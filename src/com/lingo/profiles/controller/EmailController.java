package com.lingo.profiles.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lingo.profiles.common.LingoLogger;
import com.lingo.profiles.formbean.EmailForm;
import com.lingo.profiles.utils.MailUtils;
import com.lingo.profiles.utils.WebUtils;

@Controller
@RequestMapping(value="/email")
public class EmailController {

	@RequestMapping(value={"/send"},method= RequestMethod.POST,produces = "application/json")
	public @ResponseBody EmailForm  contactUs(@RequestBody EmailForm form, HttpServletRequest request)
	{
		if(!form.validate())
		{	
			return form;
		}
		String ip = WebUtils.getRemoteAddress(request);
		String content = String.format("Name : %2$s %1$s Email: %3$s %1$s Message: %4$s %1$s IP:%5$s", "<br/>",form.getName(),form.getEmail(),form.getMessage(),ip);
		LingoLogger.logger.info(content);
		String to = com.lingo.profiles.utils.Common.EmailTo;
		//to.split(',');
		for(String t : to.split(","))
		{
			new MailUtils().SendEmail(t,form.getSubject(), content);
		}
		
		form.setResult(true);
		return form;
	}
}
