package com.aartek.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.UserDTO;
import com.aartek.service.RegistrationService;
import com.aartek.validator.RegistrationValidator;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationValidator rvalidator;
	
	
	@Autowired
	private RegistrationService rservice;
	
/*	@RequestMapping("/registration")
	public String showRegistration(Map<String, Object> map) 
	{

		System.out.println("\n Inside Registration Controller ShowRegistration method");
		
		map.put("UserReg", new UserDTO());
		
		return "registration";
	}
	

	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String showInAction(@ModelAttribute("UserReg") UserDTO user, BindingResult result)
	{
		
		System.out.println("\n Inside Registration Controller showInAction Method");
	
		First Line in Controller is calling validate()
		if we write these line at end then our validation work at the end then it is useless 
		
		
		rvalidator.validate(user, result);
		
		if(result.hasErrors())
		{
			return "registration";
			
		}
		
		else
		{

		System.out.println(user.getFname());
		
		System.out.println(user.getLname());
		
		System.out.println(user.getEmail());
		
		System.out.println(user.getPassword());
		
		System.out.println(user.getMobileno());
		
		
		rservice.checkRegistration(user);

		return "registration";

		}
	
	}*/
	
	@RequestMapping(value="/registration", method= {RequestMethod.GET, RequestMethod.POST})
	public String showRegistration(@ModelAttribute("UserReg") UserDTO user, BindingResult result, Map<String, Object> map, HttpServletRequest request)
	{
		System.out.println("Inside Show Registration Method");
		
		if(("GET").equals(request.getMethod()))
		{
			
			System.out.println("Inside Get Method");
			
			map.put("UserMap", new UserDTO());
			
			return "registration";
			
		}
		else
		{
			rvalidator.validate(user, result);
			
			if(result.hasErrors())
			{

				return "registration";
			
			}
			
			else
			{

			System.out.println("Inside Post Method");

				
			System.out.println(user.getEmail());
			
			System.out.println(user.getPassword());
			
				
			rservice.checkRegistration(user);
			
			return "registration";
			
			}

			
		}

		
		
	}
	
	

	
}
