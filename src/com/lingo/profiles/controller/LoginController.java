package com.lingo.profiles.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingo.profiles.bean.Contact;
import com.lingo.profiles.bean.Profile;
import com.lingo.profiles.bean.RPC;
import com.lingo.profiles.bean.TResult;
import com.lingo.profiles.formbean.LoginForm;
import com.lingo.profiles.utils.Common;

@Controller
@RequestMapping("/")
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model, HttpServletRequest request) {
		Profile data = com.lingo.profiles.common.Common.getModel(request, "user", Profile.class);
		if(data !=null)
		{	
			return String.format("redirect:/%s",data.getName());
		}
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute LoginForm form, ModelMap model, HttpServletRequest request)
	{
		Profile data = com.lingo.profiles.common.Common.getModel(request, "user", Profile.class);
		if(data !=null)
		{	
			return String.format("redirect:/%d",data.getName());
		}
		
		//LoginForm form = WebUtils.requestToBean(request, LoginForm.class);
		boolean flag = form.validate();
		if(!flag)//void
		{
			model.addAttribute("form", form);
			return "login";
		}
		Contact contact = new Contact();
		contact.setPhone(form.getPhone());
		contact.setPassword(Common.getMD5(form.getPassword()));
		TResult<Contact> result = new com.lingo.profiles.dao.Login().login(contact);
		if(result ==null)
		{
			model.addAttribute("message","unknown exception!");
			return "message";
		}
		switch(result.getResult())
		{
			case -2://input password error!
				form.getErrors().put("password", result.getMessage());
				model.addAttribute("form", form);
				return "login";
				//break;
			case -1://ipput phone is not exists!
				form.getErrors().put("phone", result.getMessage());
				model.addAttribute("form", form);
				return "login";
				//break;
			case 0://Exception
				model.addAttribute("message", result.getMessage());
				return "message";
				//break;
			default://default success
				//get profile info 
				RPC rpc = new RPC();
				rpc.setCid(result.getT().getId());
				TResult<Profile> res = new com.lingo.profiles.dao.RPC().getModel(rpc);
				
				switch(res.getResult())
				{
					case -1:// rpc is not exisits record.
						model.addAttribute("message",
								"your can't generate profile info ,please go to....");
						return "message";
					case 0:// exception
						model.addAttribute("message", result.getMessage());
						return "message";
					default:// success
						break;
				}
				HttpSession session = request.getSession();
				//System.out.println(data.getId());
				session.setAttribute("user", res.getT());
				//login success , redirect index	
				return String.format("redirect:/%s",res.getT().getName());
				//break;
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpServletRequest request) {
		ObjectMapper mapper = new ObjectMapper();
		Object obj = request.getSession().getAttribute("user");
		Profile data = mapper.convertValue(obj, Profile.class);
		if(obj!=null)
			request.getSession().removeAttribute("user");
		if(data!=null)
			return String.format("redirect:/%s",data.getName());
		return "";
	}
}
