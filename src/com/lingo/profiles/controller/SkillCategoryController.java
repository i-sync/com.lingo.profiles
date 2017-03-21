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
import com.lingo.profiles.bean.Login;
import com.lingo.profiles.bean.Result;
import com.lingo.profiles.bean.SkillCategory;
import com.lingo.profiles.bean.TResult;
import com.lingo.profiles.common.Common;
import com.lingo.profiles.common.LingoLogger;
import com.lingo.profiles.formbean.SkillCategoryForm;
import com.lingo.profiles.formbean.SkillForm;
import com.lingo.profiles.utils.WebUtils;

@Controller
@RequestMapping(value = {"/skillcategory"})
public class SkillCategoryController {

	/**
	 * get skill category list.
	 */
	@Login
	@ModelAttribute(value = "list")
	public List<SkillCategory> getCategoryList(HttpServletRequest request)
	{
		SkillCategory data = new SkillCategory();
		data.setPid(Common.getPid(request));
		ListResult<SkillCategory> result = new com.lingo.profiles.dao.SkillCategory().getList(data);
		return result.getList();
	}
	
	@Login
	@RequestMapping(value = {"/add"}, method = RequestMethod.GET)
	public String addSkillCategory(ModelMap model) {
		return "skill_category_add";
	}

	@Login
	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public String addSkillCategory(@ModelAttribute SkillCategoryForm form, ModelMap model, HttpServletRequest request) {
		//SkillCategoryForm form = WebUtils.requestToBean(request, SkillCategoryForm.class);
		form.setPid(Common.getPid(request));
		if(!form.validate())
		{
			model.addAttribute("form",form);
			return "skill_category_add";
		}
		
		SkillCategory data = new SkillCategory();
		WebUtils.copyBean(form, data);

		com.lingo.profiles.dao.SkillCategory skillcategory = new com.lingo.profiles.dao.SkillCategory();
		Result result = skillcategory.add(data);
		if (result.getResult() != 1) {
			// error....
			LingoLogger.logger.info(String.format("controller level: add skill category error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		
		return "redirect:/skillcategory/add";
	}
	
	@Login
	@RequestMapping(value = {"/update/{id}"}, method = RequestMethod.GET)
	public String updateSkillCategory(@PathVariable int id, ModelMap model) {
		return String.format("redirect:/skillcategory/model/%d", id);
	}

	@Login
	@RequestMapping(value={"/update"},method = RequestMethod.POST)
	public String updateSkillCategory(@ModelAttribute SkillCategoryForm form, ModelMap model,HttpServletRequest request)
	{
		//SkillCategoryForm form = WebUtils.requestToBean(request, SkillCategoryForm.class);
		form.setPid(Common.getPid(request));
		if(!form.validate())
		{
			model.addAttribute("form",form);
			return "skill_category_update";
		}
		
		SkillCategory data = new SkillCategory();
		WebUtils.copyBean(form, data);

		com.lingo.profiles.dao.SkillCategory skillcategory = new com.lingo.profiles.dao.SkillCategory();
		Result result = skillcategory.update(data);
		if (result.getResult() != 1) {
			// error....
			LingoLogger.logger.info(String.format("controller level: update skill category error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		return "redirect:/skillcategory/add";
	}

	@Login
	@RequestMapping(value={"/delete/{id}"},method=RequestMethod.GET)
	public String deleteSkillCategory(@PathVariable int id, ModelMap model)
	{
		SkillCategory data = new SkillCategory();
		data.setId(id);
		
		com.lingo.profiles.dao.SkillCategory skillcategory = new com.lingo.profiles.dao.SkillCategory();
		Result result = skillcategory.delete(data);
		if(result.getResult()!=1)
		{
			//error....
			LingoLogger.logger.info(String.format("controller level: delete skill category error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		return "redirect:/skillcategory/add";
	}

	@Login
	@RequestMapping(value={"/model/{id}"},method=RequestMethod.GET)
	public String getModel(@PathVariable int id, ModelMap model)
	{
		SkillCategory data = new SkillCategory();
		data.setId(id);
		
		com.lingo.profiles.dao.SkillCategory skillcategory = new com.lingo.profiles.dao.SkillCategory();
		TResult<SkillCategory> result = skillcategory.getModel(data);
		if(result.getResult()!=1)
		{
			//error
			LingoLogger.logger.info(String.format("controller level: get skill category model error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
			
		}
		SkillCategoryForm form = new SkillCategoryForm();
		data = result.getT();
		WebUtils.copyBean(data, form);
		model.addAttribute("form", form);
		
		return "skill_category_update";
	}
}
