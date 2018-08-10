package com.aartek.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aartek.model.Product;
import com.aartek.model.User;
import com.aartek.service.RegistrationService;

@Controller
public class RegistrationController 
{

	private static final Logger log = Logger.getLogger(RegistrationController.class);

	@Autowired
	private RegistrationService rservice;
	
	@RequestMapping(value="/registration")
	public String registrationGET(Model map)
	{
	
		log.info("Registration Controller :---- Registraion GET Method  ");
		
		map.addAttribute("UserSignUP", new User());
				
		return "registration";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registrationPOST(@ModelAttribute("UserSignUP") User user, Map<String, Object> map)
	{
	
		log.info("Registration Controller :---- Registraion POST Method  ");
		
		rservice.saveUser(user);		
		
		map.put("userList", rservice.getAllUser(user));
		
		return "alluser";
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getUserList(User user, Map<String, Object> map)
	{
		log.info("Registration Controller :---- Registraion POST Employee List Method  ");
		
		map.put("userList", rservice.getAllUser(user));
				
		
		return "alluser";
	}
	
	 @RequestMapping(value="/edit-{id}", method=RequestMethod.GET)
	 public ModelAndView editUserGet(@PathVariable Integer id, Model model)
	 {
		 log.info("Registration Controller :---- Edit User GET Method  ");
		 
		 System.out.println("ID :-- "+id);
		 
		 User user=rservice.getSingleUser(id);
		 
		 model.addAttribute("UserUpdate", user);
		 
		 return new ModelAndView("updateUser", "command" ,user);
	 }
	 
	 
	 @RequestMapping(value="/updateUser", method=RequestMethod.POST)
	 public String editUserPost(@ModelAttribute("UserUpdate") User user, Map<String, Object> map)
	 {

		 log.info("Registration Controller :---- Edit User POST Method  ");

		rservice.editUser(user); 	
					
		map.put("userList", rservice.getAllUser(user));

		return "alluser";

	 }
	 
	
	 @RequestMapping(value="/delete-{id}", method=RequestMethod.GET)
	 public String deleteUserDetails(@PathVariable Integer id, Map<String, Object> map)
	 {
		 log.info("Registration Controller :---- Delete User GET Method  ");
	
		 
		 System.out.println("ID :-- "+id);

		 
		 User user=rservice.deleteUserService(id);

		 map.put("userList", rservice.getAllUser(user));
		 
		 return "alluser";
	 }

	
}
