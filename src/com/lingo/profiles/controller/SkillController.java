package com.lingo.profiles.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lingo.profiles.bean.ListResult;
import com.lingo.profiles.bean.Result;
import com.lingo.profiles.bean.Skill;
import com.lingo.profiles.bean.TResult;
import com.lingo.profiles.common.LingoLogger;
import com.lingo.profiles.formbean.SkillForm;
import com.lingo.profiles.utils.WebUtils;

@Controller
@RequestMapping(value = {"/skill"})
public class SkillController {
	
	int pid=1;
	/**
	 * get skill list by pid 
	 * @return
	 */	
	@ModelAttribute(value="list")
	public List<Skill> getList()
	{
		Skill data = new Skill();
		data.setPid(pid);
		com.lingo.profiles.dao.Skill skill = new com.lingo.profiles.dao.Skill();
		ListResult<Skill> result = skill.getList(data);
		if(result.getResult()!=1)
		{
			//error
		}
		return result.getList();
	}
	@RequestMapping(value = {"/add"}, method = RequestMethod.GET)
	public String addSkill(ModelMap model) {
		return "skill_add";
	}

	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public String addSkill(ModelMap model, HttpServletRequest request) {
		SkillForm form = WebUtils.requestToBean(request, SkillForm.class);
		form.setPid(pid);
		if(!form.validate())
		{
			model.addAttribute("form",form);
			return "skill_add";
		}
		
		Skill data = new Skill();
		WebUtils.copyBean(form, data);

		com.lingo.profiles.dao.Skill skill = new com.lingo.profiles.dao.Skill();
		Result result = skill.add(data);
		if (result.getResult() != 1) {
			// error....
			LingoLogger.logger.info(String.format("controller level: add skill error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		
		return "redirect:/skill/add";
	}
	
	
	@RequestMapping(value = {"/update/{id}"}, method = RequestMethod.GET)
	public String updateSkill(@PathVariable int id, ModelMap model) {
		return String.format("redirect:/skill/model/%d", id);
	}
	
	@RequestMapping(value={"/update"},method = RequestMethod.POST)
	public String updateSkill(ModelMap model,HttpServletRequest request)
	{
		SkillForm form = WebUtils.requestToBean(request, SkillForm.class);
		form.setPid(pid);
		if(!form.validate())
		{
			model.addAttribute("form",form);
			return "skill_update";
		}
		
		Skill data = new Skill();
		WebUtils.copyBean(form, data);

		com.lingo.profiles.dao.Skill skill = new com.lingo.profiles.dao.Skill();
		Result result = skill.update(data);
		if (result.getResult() != 1) {
			// error....
			LingoLogger.logger.info(String.format("controller level: update skill error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		return "redirect:/skill/add";
	}
	
	@RequestMapping(value={"/delete/{id}"},method=RequestMethod.GET)
	public String deleteSkill(@PathVariable int id, ModelMap model)
	{
		Skill data = new Skill();
		data.setId(id);
		
		com.lingo.profiles.dao.Skill skill = new com.lingo.profiles.dao.Skill();
		Result result = skill.delete(data);
		if(result.getResult()!=1)
		{
			//error....
			LingoLogger.logger.info(String.format("controller level: delete skill error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		return "redirect:/skill/add";
	}
	
	@RequestMapping(value={"/model/{id}"},method=RequestMethod.GET)
	public String getModel(@PathVariable int id, ModelMap model)
	{
		Skill data = new Skill();
		data.setId(id);
		
		com.lingo.profiles.dao.Skill skill = new com.lingo.profiles.dao.Skill();
		TResult<Skill> result = skill.getModel(data);
		if(result.getResult()!=1)
		{
			//error
			LingoLogger.logger.info(String.format("controller level: get skill model error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
			
		}
		SkillForm form = new SkillForm();
		data = result.getT();
		WebUtils.copyBean(data, form);
		model.addAttribute("form", form);
		
		return "skill_update";
	}
}
