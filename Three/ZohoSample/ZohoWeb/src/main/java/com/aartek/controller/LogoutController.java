package com.aartek.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aartek.model.UserDTO;

@Controller
public class LogoutController {

	
	@RequestMapping(value="/logout")
	public void showlogout(HttpServletRequest req, HttpServletResponse res)
	{
		
		System.out.println("Inside Logout Controller ");
		
		try
		{
			req.getSession().removeAttribute("USERS");
			
			UserDTO user=(UserDTO) req.getSession().getAttribute("USERS");
			
			System.out.println("lohhgjgg :- "+user);
			
			res.sendRedirect("login.do");
				
		}
		catch(Exception e)
		{
			System.out.println("Exception Occur in Logout");
			
		}
		
	}
	
}
