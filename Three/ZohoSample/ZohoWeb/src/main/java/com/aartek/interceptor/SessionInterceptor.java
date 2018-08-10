package com.aartek.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.aartek.model.UserDTO;

@Component
public class SessionInterceptor extends HandlerInterceptorAdapter 
{

	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3)
			throws Exception {

		System.out.println("Session Interceptor :- After Completion Method.");
		
		
	}

	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object arg2, ModelAndView arg3)
			throws Exception {

		System.out.println("Session Interceptor :- Post Handle Method");
		
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {

		System.out.println("Session Interceptor :- Pre Handler Method");
		
		
		UserDTO user=(UserDTO)req.getSession().getAttribute("USERS");
		
		System.out.println("Sgneghjft :- "+user);
		
		if(user==null || user.equals(""))
		{
			
			res.sendRedirect("login.do");
			
			return false;
			
		}
		
		return true;
	}

	
	
}
