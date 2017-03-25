package com.lingo.profiles.controller;

import java.util.List;
import java.util.stream.Collectors;

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
import com.lingo.profiles.bean.Experience;
import com.lingo.profiles.bean.TResult;
import com.lingo.profiles.common.Common;
import com.lingo.profiles.common.LingoLogger;
import com.lingo.profiles.formbean.ExperienceForm;
import com.lingo.profiles.utils.WebUtils;

@Controller
@RequestMapping(value={"/experience"})
public class ExperienceController {
	
	/**
	 * get experience list by pid
	 * @return
	 */
	@Login
	@ModelAttribute(value="list")
	public List<Experience> getList(HttpServletRequest request)
	{
		Experience data = new Experience();
		data.setPid(Common.getPid(request));
		
		com.lingo.profiles.dao.Experience experience = new com.lingo.profiles.dao.Experience();
		ListResult<Experience> result = experience.getList(data);
		if(result.getResult()!=1)
		{
			//error...
		}
		return result.getList().stream().map(x -> { x.setLogo(Common.getFileUrl(request, Experience.class.getName(), x.getLogo())); return x;}).collect(Collectors.toList());
	}
	@Login
	@RequestMapping(value = {"/add"}, method = RequestMethod.GET)
	public String addExperience(ModelMap model) {
		return "experience_add";
	}

	@Login
	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public String addExperience(@RequestParam(value = "logo") MultipartFile file, ModelMap model, HttpServletRequest request) {
		ExperienceForm form = WebUtils.requestToBean(request, ExperienceForm.class);
		form.setPid(Common.getPid(request));
		if (!file.isEmpty()) {
			String fileName = com.lingo.profiles.common.Common.saveFile(request, file, Experience.class.getName());	
			form.setLogo(fileName);
		}		
		
		if(!form.validate())
		{
			model.addAttribute("form", form);
			return "experience_add";
		}
		
		Experience data = new Experience();
		WebUtils.copyBean(form, data);

		com.lingo.profiles.dao.Experience experience = new com.lingo.profiles.dao.Experience();
		Result result = experience.add(data);
		if (result.getResult() != 1) {
			// error....
			LingoLogger.logger.info(String.format("controller level: add experience error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}

		return "redirect:/experience/add";
	}

	@Login
	@RequestMapping(value = {"/update/{id}"}, method = RequestMethod.GET)
	public String updateExperience(@PathVariable int id, ModelMap model) {
		return String.format("redirect:/experience/model/%d",id);
	}

	@Login
	@RequestMapping(value={"/update"},method = RequestMethod.POST)
	public String updateExperience(@RequestParam(value = "logo") MultipartFile file, ModelMap model,HttpServletRequest request)
	{
		ExperienceForm form = WebUtils.requestToBean(request, ExperienceForm.class);
		form.setPid(Common.getPid(request));
		if (!file.isEmpty()) {
			String fileName = com.lingo.profiles.common.Common.saveFile(request, file, Experience.class.getName());	
			form.setLogo(fileName);
		}
		
		if(!form.validate())
		{
			model.addAttribute("form", form);
			return "experience_update";
		}
		Experience data = new Experience();
		WebUtils.copyBean(form, data);

		com.lingo.profiles.dao.Experience experience = new com.lingo.profiles.dao.Experience();
		Result result = experience.update(data);
		if (result.getResult() != 1) {
			// error....
			LingoLogger.logger.info(String.format("controller level: update experience error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		return "redirect:/experience/add";
	}

	@Login
	@RequestMapping(value={"/delete/{id}"},method=RequestMethod.GET)
	public String deleteExperience(@PathVariable int id, ModelMap model)
	{
		Experience data = new Experience();
		data.setId(id);
		
		com.lingo.profiles.dao.Experience experience = new com.lingo.profiles.dao.Experience();
		Result result = experience.delete(data);
		if(result.getResult()!=1)
		{
			//error....
			LingoLogger.logger.info(String.format("controller level: delete experience error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		
		return "redirect:/experience/add";
	}

	@Login
	@RequestMapping(value={"/model/{id}"},method=RequestMethod.GET)
	public String getModel(@PathVariable int id, ModelMap model, HttpServletRequest request)
	{
		Experience data = new Experience();
		data.setId(id);
		
		com.lingo.profiles.dao.Experience experience = new com.lingo.profiles.dao.Experience();
		TResult<Experience> result = experience.getModel(data);
		if(result.getResult()!=1)
		{
			//error
			LingoLogger.logger.info(String.format("controller level: get experience model error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
			
		}
		ExperienceForm form = new ExperienceForm();
		data = result.getT();
		WebUtils.copyBean(data, form);
		form.setLogo(Common.getFileUrl(request, Experience.class.getName(), form.getLogo()));
		model.addAttribute("form", form);
		
		return "experience_update";
	}
}
