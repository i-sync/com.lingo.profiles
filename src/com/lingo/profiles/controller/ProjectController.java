package com.lingo.profiles.controller;

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
import com.lingo.profiles.bean.Project;
import com.lingo.profiles.bean.TResult;
import com.lingo.profiles.common.Common;
import com.lingo.profiles.common.LingoLogger;
import com.lingo.profiles.formbean.ProjectForm;
import com.lingo.profiles.utils.WebUtils;

@Controller
@RequestMapping(value={"/project"})
public class ProjectController {
	
	/**
	 * get project list by pid
	 * @return
	 */
	@Login
	@ModelAttribute(value="list")
	public List<ProjectForm> getList(HttpServletRequest request)
	{
		Project data = new Project();
		data.setPid(Common.getPid(request));
		com.lingo.profiles.dao.Project project = new com.lingo.profiles.dao.Project();
		ListResult<Project> result = project.getList(data);
		if(result.getResult()!=1)
		{
			//error...
			
		}
		
		//convert to projectform
		List<ProjectForm> list = new ArrayList<ProjectForm>();
		for(Project item : result.getList())
		{
			ProjectForm form = new ProjectForm();
			WebUtils.copyBean(item, form);
			form.setImage(Common.getFileUrl(request, Project.class.getName(), form.getImage()));
			list.add(form);
		}
		return list;
	}

	@Login
	@RequestMapping(value = {"/add"}, method = RequestMethod.GET)
	public String addProject(ModelMap model) {
		return "project_add";
	}

	@Login
	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public String addProject(@RequestParam(value = "image") MultipartFile file, ModelMap model, HttpServletRequest request) {
		ProjectForm form = WebUtils.requestToBean(request, ProjectForm.class);
		form.setPid(Common.getPid(request));
		if (!file.isEmpty()) {
			String fileName = com.lingo.profiles.common.Common.saveFile(request, file, Project.class.getName());	
			form.setImage(fileName);
		}
		
		//check
		if(!form.validate())
		{
			model.addAttribute("form", form);
			return "project_add";
		}
		
		Project data = new Project();
		WebUtils.copyBean(form, data);

		com.lingo.profiles.dao.Project project = new com.lingo.profiles.dao.Project();
		Result result = project.add(data);
		if (result.getResult() != 1) {
			// error....
			LingoLogger.logger.info(String.format("controller level: add project error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}

		return "redirect:/project/add";
	}

	@Login
	@RequestMapping(value = {"/update/{id}"}, method = RequestMethod.GET)
	public String updateProject(@PathVariable int id, ModelMap model) {
		return String.format("redirect:/project/model/%d", id);
	}

	@Login
	@RequestMapping(value={"/update"},method = RequestMethod.POST)
	public String updateProject(@RequestParam(value = "image") MultipartFile file, ModelMap model,HttpServletRequest request)
	{
		ProjectForm form = WebUtils.requestToBean(request, ProjectForm.class);
		form.setPid(Common.getPid(request));
		if (!file.isEmpty()) {
			String fileName = com.lingo.profiles.common.Common.saveFile(request, file, Project.class.getName());	
			form.setImage(fileName);
		}
		//check
		if(!form.validate())
		{
			model.addAttribute("form", form);
			return "project_update";
		}
				
		Project data = new Project();
		WebUtils.copyBean(form, data);

		com.lingo.profiles.dao.Project project = new com.lingo.profiles.dao.Project();
		Result result = project.update(data);
		if (result.getResult() != 1) {
			// error....
			LingoLogger.logger.info(String.format("controller level: update project error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		return "redirect:/project/add";
	}

	@Login
	@RequestMapping(value={"/delete/{id}"},method=RequestMethod.GET)
	public String deleteProject(@PathVariable int id, ModelMap model)
	{
		Project data = new Project();
		data.setId(id);
		
		com.lingo.profiles.dao.Project project = new com.lingo.profiles.dao.Project();
		Result result = project.delete(data);
		if(result.getResult()!=1)
		{
			//error....
			LingoLogger.logger.info(String.format("controller level: delete project error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		
		return "redirect:/project/add";
	}

	@Login
	@RequestMapping(value={"/model/{id}"},method=RequestMethod.GET)
	public String getModel(@PathVariable int id, ModelMap model, HttpServletRequest request)
	{
		Project data = new Project();
		data.setId(id);
		
		com.lingo.profiles.dao.Project project = new com.lingo.profiles.dao.Project();
		TResult<Project> result = project.getModel(data);
		if(result.getResult()!=1)
		{
			//error
			LingoLogger.logger.info(String.format("controller level: get project model error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
			
		}
		ProjectForm form = new ProjectForm();
		data = result.getT();
		WebUtils.copyBean(data, form);
		form.setImage(Common.getFileUrl(request, Project.class.getName(), form.getImage()));
		model.addAttribute("form", form);
		
		return "project_update";
	}
}
