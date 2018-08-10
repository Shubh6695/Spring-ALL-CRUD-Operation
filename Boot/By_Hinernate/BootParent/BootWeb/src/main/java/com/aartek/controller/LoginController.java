package com.aartek.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.Product;
import com.aartek.model.User;
import com.aartek.service.LoginService;
import com.aartek.service.ProductService;

@Controller
public class LoginController {

	private static final Logger log=Logger.getLogger(LoginService.class);

	@Autowired
	private LoginService lservice;
	
	
	@RequestMapping(value="/login")
	public String loginGET(Model map)
	{
	
		log.info("Login Controller :---- Login GET Method  ");
		
		map.addAttribute("UserLogin", new User());
				
		return "login";
	}

	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPOST(@ModelAttribute("UserLogin") User user, Map<String, Object> map)
	{
	
		
		log.info("Login Controller :---- Login POST Method  ");
		
	
		boolean status= lservice.checkLogin(user.getEmail(), user.getPassword());
				
		if(status==true)
		{
		
		
		return "redirect:/product";
		
		}
		
		return "login";
	}
	

	
}
