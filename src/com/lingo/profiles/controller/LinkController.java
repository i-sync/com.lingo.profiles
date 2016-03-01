package com.lingo.profiles.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lingo.profiles.bean.Result;
import com.lingo.profiles.bean.Link;
import com.lingo.profiles.bean.TResult;
import com.lingo.profiles.common.LingoLogger;
import com.lingo.profiles.formbean.LinkForm;
import com.lingo.profiles.utils.WebUtils;

@Controller
@RequestMapping(value={"/link"})
public class LinkController {
	@RequestMapping(value = {"/add"}, method = RequestMethod.GET)
	public String addLink(ModelMap model) {
		return "link_add";
	}

	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public String addLink(@RequestParam(value = "logo") MultipartFile file, ModelMap model, HttpServletRequest request) {
		LinkForm form = WebUtils.requestToBean(request, LinkForm.class);
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
		Link data = new Link();
		WebUtils.copyBean(form, data);

		com.lingo.profiles.dao.Link link = new com.lingo.profiles.dao.Link();
		Result result = link.add(data);
		if (result.getResult() != 1) {
			// error....
			LingoLogger.logger.info(String.format("controller level: add link error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}

		return "link_list";
	}

	@RequestMapping(value = {"/update"}, method = RequestMethod.GET)
	public String updateLink(ModelMap model) {
		return "link_update";
	}
	
	@RequestMapping(value={"/update"},method = RequestMethod.POST)
	public String updateLink(@RequestParam(value = "logo") MultipartFile file, ModelMap model,HttpServletRequest request)
	{
		LinkForm form = WebUtils.requestToBean(request, LinkForm.class);
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
		Link data = new Link();
		WebUtils.copyBean(form, data);

		com.lingo.profiles.dao.Link link = new com.lingo.profiles.dao.Link();
		Result result = link.update(data);
		if (result.getResult() != 1) {
			// error....
			LingoLogger.logger.info(String.format("controller level: update link error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		return "link_list";
	}
	
	@RequestMapping(value={"/delete/{id}"},method=RequestMethod.POST)
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
		
		return "link_list";
	}
	
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
