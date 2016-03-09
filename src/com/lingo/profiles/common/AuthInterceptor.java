package com.lingo.profiles.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingo.profiles.bean.Login;
import com.lingo.profiles.bean.Profile;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod handler2 = (HandlerMethod) handler;
	    Login login = handler2.getMethodAnnotation(Login.class);

	    if (null == login) {
	        // 没有声明权限,放行
	        return true;
	    }
	    
		Profile data = com.lingo.profiles.common.Common.getModel(request, "user", Profile.class);
		if(data ==null)
		{
			response.sendRedirect(request.getContextPath()+"/login");
			//return ;
		}
		return true;
	}
}
