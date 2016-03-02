package com.lingo.profiles.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lingo.profiles.bean.Education;
import com.lingo.profiles.bean.Link;
import com.lingo.profiles.bean.Living;
import com.lingo.profiles.bean.Profile;
import com.lingo.profiles.bean.Project;
import com.lingo.profiles.bean.Result;
import com.lingo.profiles.bean.Skill;
import com.lingo.profiles.bean.TResult;
import com.lingo.profiles.common.LingoLogger;
import com.lingo.profiles.formbean.EducationForm;
import com.lingo.profiles.formbean.LinkForm;
import com.lingo.profiles.formbean.LivingForm;
import com.lingo.profiles.formbean.ProfileForm;
import com.lingo.profiles.formbean.ProjectForm;
import com.lingo.profiles.formbean.SkillForm;
import com.lingo.profiles.utils.WebUtils;

@Controller
@RequestMapping(value = { "/profile" })
public class ProfileController {

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String addProfile(ModelMap model) {
		return "profile_add";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String addProfile(
			@RequestParam(value = "avatar") MultipartFile file, ModelMap model,
			HttpServletRequest request) {

		ProfileForm form = WebUtils.requestToBean(request, ProfileForm.class);
		if (!file.isEmpty()) {
			try {
				InputStream is = file.getInputStream();
				byte[] avatar = new byte[is.available()];
				is.read(avatar);
				form.setAvatar(avatar);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// check
		if(!form.validate())
		{
			model.addAttribute("form", form);
			return "profile_add";
		}

		Profile data = new Profile();
		WebUtils.copyBean(form, data);

		// write database
		com.lingo.profiles.dao.Profile profile = new com.lingo.profiles.dao.Profile();
		Result result = profile.add(data);
		if (result.getResult() != 1)// error
		{
			// .....
			LingoLogger.logger.info(String.format("controller level: add profile error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}

		return "redirect:/profile/add";
	}
	
	@RequestMapping(value={"/update"},method=RequestMethod.POST)
	public String updateProfile(@RequestParam(value = "avatar") MultipartFile file, ModelMap model,
			HttpServletRequest request)
	{
		ProfileForm form = WebUtils.requestToBean(request, ProfileForm.class);
		if (!file.isEmpty()) {
			try {
				InputStream is = file.getInputStream();
				byte[] avatar = new byte[is.available()];
				is.read(avatar);
				form.setAvatar(avatar);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// check
		if(!form.validate())
		{
			model.addAttribute("form", form);
			return "profile_update";
		}

		Profile data = new Profile();
		WebUtils.copyBean(form, data);

		// write database
		com.lingo.profiles.dao.Profile profile = new com.lingo.profiles.dao.Profile();
		Result result = profile.update(data);
		if (result.getResult() != 1)// error
		{
			// .....
			LingoLogger.logger.info(String.format("controller level: add profile error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}

		return String.format("redirect:/profile/%d",data.getId());
	}
	
	@RequestMapping(value={"/delete/{id}"},method=RequestMethod.POST)
	public String deleteProfile(@PathVariable int id, ModelMap model)
	{
		Profile data = new Profile();
		data.setId(id);
		
		com.lingo.profiles.dao.Profile profile = new com.lingo.profiles.dao.Profile();
		Result result = profile.delete(data);
		if(result.getResult()!=1)
		{
			//error....
			LingoLogger.logger.info(String.format("controller level: delete profile error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		
		return "project_list";
	}

	@RequestMapping(value = { "/model/{id}" }, method = RequestMethod.GET)
	public String getModel(@PathVariable int id, ModelMap model) {
		Profile data = new Profile();
		data.setId(id);

		com.lingo.profiles.dao.Profile profile = new com.lingo.profiles.dao.Profile();
		TResult<Profile> result = profile.getModel(data);
		if (result.getResult() != 1) {
			// error
			LingoLogger.logger.info(String.format("controller level: get profile model error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		data = result.getT();
		ProfileForm form = new ProfileForm();
		WebUtils.copyBean(data, form);
		//copy list property
		List<SkillForm> temp1 = new ArrayList<SkillForm>();
		for(Skill item : data.getSkill())
		{
			SkillForm skill = new SkillForm();
			WebUtils.copyBean(item, skill);
			temp1.add(skill);
		}
		form.setSkill(temp1);
		
		List<ProjectForm> temp2 = new ArrayList<ProjectForm>();
		for(Project item : data.getProject())
		{
			ProjectForm project = new ProjectForm();
			WebUtils.copyBean(item, project);
			temp2.add(project);
		}
		form.setProject(temp2);
		
		List<EducationForm> temp3 = new ArrayList<EducationForm>();
		for(Education item : data.getEducation())
		{
			EducationForm education = new EducationForm();
			WebUtils.copyBean(item, education);
			temp3.add(education);
		}
		form.setEducation(temp3);
		
		List<LivingForm> temp4 = new ArrayList<LivingForm>();
		for(Living item : data.getLiving())
		{
			LivingForm living = new LivingForm();
			WebUtils.copyBean(item, living);
			temp4.add(living);
		}
		form.setLiving(temp4);
		
		List<LinkForm> temp5 = new ArrayList<LinkForm>();
		for(Link item : data.getLink())
		{
			LinkForm link = new LinkForm();
			WebUtils.copyBean(item, link);
			temp5.add(link);
		}		
		form.setLink(temp5);
		
		model.addAttribute("form", form);

		return "index";
	}
}
