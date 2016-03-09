package com.lingo.profiles.common;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingo.profiles.bean.Profile;

public class Common {

	/**
	 * get session model form request
	 * 
	 * @param request
	 * @param classType
	 * @return
	 */
	public static <T> T getModel(HttpServletRequest request, String name, Class<T> classType) {
		T t;
		ObjectMapper mapper = new ObjectMapper();
		Object obj = request.getSession().getAttribute(name);
		t = mapper.convertValue(obj, classType);
		return t;
	}

	/**
	 * get pid
	 * 
	 * @param request
	 * @return
	 */
	public static int getPid(HttpServletRequest request) {
		Profile data = getModel(request, "user", Profile.class);
		return data == null ? 0 : data.getId();
	}
}
