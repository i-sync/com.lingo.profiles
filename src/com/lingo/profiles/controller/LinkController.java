package com.lingo.profiles.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lingo.profiles.bean.ListResult;
import com.lingo.profiles.bean.Login;
import com.lingo.profiles.bean.Result;
import com.lingo.profiles.bean.Social;
import com.lingo.profiles.bean.Link;
import com.lingo.profiles.bean.TResult;
import com.lingo.profiles.common.LingoLogger;
import com.lingo.profiles.formbean.LinkForm;
import com.lingo.profiles.utils.Common;
import com.lingo.profiles.utils.WebUtils;

@Controller
@RequestMapping(value={"/link"})
public class LinkController {
	
	/**
	 * get link list by pid
	 * @return
	 */
	@Login
	@ModelAttribute(value="list")
	public List<LinkForm> getList(HttpServletRequest request)
	{
		Link data = new Link();
		data.setPid(com.lingo.profiles.common.Common.getPid(request));
		
		com.lingo.profiles.dao.Link link = new com.lingo.profiles.dao.Link();
		ListResult<Link> result = link.getList(data);
		if(result.getResult()!=1)
		{
			//error....
			LingoLogger.logger.info(String.format("controller level : Link get list faild , result:%d,message:%s",result.getResult(),result.getMessage()));
		}
		
		List<LinkForm> list = new ArrayList<LinkForm>();
		for(Link item : result.getList())
		{
			LinkForm form = new LinkForm();
			WebUtils.copyBean(item, form);
			list.add(form);
		}
		return list;
	}
	
	/**
	 * get social icon
	 * @return
	 */
	@ModelAttribute(value="social")
	public List<Social> getSocialIcon()
	{
		return Common.getSocialIcon();
	}

	@Login
	@RequestMapping(value = {"/add"}, method = RequestMethod.GET)
	public String addLink(ModelMap model) {
		return "link_add";
	}

	@Login
	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public String addLink(@RequestParam(value = "logo") MultipartFile file, ModelMap model, HttpServletRequest request) {
		LinkForm form = WebUtils.requestToBean(request, LinkForm.class);
		form.setPid(com.lingo.profiles.common.Common.getPid(request));
		if (!file.isEmpty()) {
			try {
				InputStream is = file.getInputStream();
				byte[] logo = new byte[is.available()];
				is.read(logo);
				form.setLogo(logo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//check
		if(!form.validate())
		{
			model.addAttribute("form", form);
			return "link_add";
		}
		
		Link data = new Link();
		WebUtils.copyBean(form, data);

		com.lingo.profiles.dao.Link link = new com.lingo.profiles.dao.Link();
		Result result = link.add(data);
		if (result.getResult() != 1) {
			// error....
			LingoLogger.logger.info(String.format("controller level: add link error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}

		return "redirect:/link/add";
	}

	@Login
	@RequestMapping(value = {"/update/{id}"}, method = RequestMethod.GET)
	public String updateLink(@PathVariable int id, ModelMap model) {
		return String.format("redirect:/link/model/%d",id);
	}

	@Login
	@RequestMapping(value={"/update"},method = RequestMethod.POST)
	public String updateLink(@RequestParam(value = "logo") MultipartFile file, ModelMap model,HttpServletRequest request)
	{
		LinkForm form = WebUtils.requestToBean(request, LinkForm.class);
		form.setPid(com.lingo.profiles.common.Common.getPid(request));
		if (!file.isEmpty()) {
			try {
				InputStream is = file.getInputStream();
				byte[] logo = new byte[is.available()];
				is.read(logo);
				form.setLogo(logo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//check
		if(!form.validate())
		{
			model.addAttribute("form", form);
			return "link_add";
		}
		Link data = new Link();
		WebUtils.copyBean(form, data);

		com.lingo.profiles.dao.Link link = new com.lingo.profiles.dao.Link();
		Result result = link.update(data);
		if (result.getResult() != 1) {
			// error....
			LingoLogger.logger.info(String.format("controller level: update link error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		return "redirect:/link/add";
	}

	@Login
	@RequestMapping(value={"/delete/{id}"},method=RequestMethod.GET)
	public String deleteLink(@PathVariable int id, ModelMap model)
	{
		Link data = new Link();
		data.setId(id);
		
		com.lingo.profiles.dao.Link link = new com.lingo.profiles.dao.Link();
		Result result = link.delete(data);
		if(result.getResult()!=1)
		{
			//error....
			LingoLogger.logger.info(String.format("controller level: delete link error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		
		return "redirect:/link/add";
	}

	@Login
	@RequestMapping(value={"/model/{id}"},method=RequestMethod.GET)
	public String getModel(@PathVariable int id, ModelMap model)
	{
		Link data = new Link();
		data.setId(id);
		
		com.lingo.profiles.dao.Link link = new com.lingo.profiles.dao.Link();
		TResult<Link> result = link.getModel(data);
		if(result.getResult()!=1)
		{
			//error
			LingoLogger.logger.info(String.format("controller level: get link model error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
			
		}
		LinkForm form = new LinkForm();
		data = result.getT();
		WebUtils.copyBean(data, form);
		model.addAttribute("form", form);
		
		return "link_update";
	}
}
