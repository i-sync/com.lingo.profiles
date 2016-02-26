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

import com.lingo.profiles.bean.Profile;
import com.lingo.profiles.bean.Result;
import com.lingo.profiles.bean.TResult;
import com.lingo.profiles.formbean.ProfileForm;
import com.lingo.profiles.utils.WebUtils;

@Controller
@RequestMapping(value = { "/profile" })
public class ProfileController {

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String addProfile(ModelMap model) {
		return "add";
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
		// .......

		Profile data = new Profile();
		WebUtils.copyBean(form, data);

		// write database
		com.lingo.profiles.dao.Profile profile = new com.lingo.profiles.dao.Profile();
		Result result = profile.add(data);
		if (result.getResult() != 1)// error
		{
			// .....
		}

		return "redirect:/profile/add";
	}

	@RequestMapping(value = { "/model/{id}" }, method = RequestMethod.GET)
	public String getModel(@PathVariable int id, ModelMap model) {
		Profile data = new Profile();
		data.setId(id);

		com.lingo.profiles.dao.Profile profile = new com.lingo.profiles.dao.Profile();
		TResult<Profile> result = profile.getModel(data);
		if (result.getResult() != 1) {
			// todo
		}
		ProfileForm form = new ProfileForm();
		WebUtils.copyBean(result.getT(), form);
		model.addAttribute("form", form);

		return "index";
	}
}
