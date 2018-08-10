package com.aartek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aartek.model.User;
import com.aartek.serviceImpl.RegistrationImpl;

import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;

@Controller
public class RegistrationController {

	
	private static final Logger log = Logger.getLogger(RegistrationController.class);
	
	@Autowired
	private RegistrationImpl rservice;

	@GetMapping("/registration")
	public String registrationGET(Model map)
	{
		
		log.info("Registration Controller :---- Registraion GET Method  ");
		
		map.addAttribute("UserSignUP", new User());

		return "registration";
	}
	
	@PostMapping("/registration")
	public String  registrationPOST(@ModelAttribute("UserSignUP") User user, Map<String, Object> map)
	{
		
		log.info("Registration Controller :---- Registraion POST Method  ");
		
		rservice.createUser(user);		
		
		map.put("userList", rservice.getUser());
		
		return "alluser";

		
		
	}
	@GetMapping("/list")
	public String getUserList(User user, Map<String, Object> map)
	{
		log.info("Registration Controller :---- GET User List Method  ");
		
		map.put("userList", rservice.getUser());
						
		return "alluser";
	}

	
	@GetMapping("/delete-{id}")
	 public String deleteUserDetails(@PathVariable Integer id, Map<String, Object> map)
	 {
		 log.info("Registration Controller :---- Delete User GET Method  ");
	
		 
		 System.out.println("ID :-- "+id);

		 
		 rservice.deleteUserById(id);

		 map.put("userList", rservice.getUser());
		 
		 return "alluser";
	 }
	
	
	@GetMapping("/edit-{id}")
	 public ModelAndView editUserGet(@PathVariable Integer id, Model model)
	 {
		 log.info("Registration Controller :---- Edit User GET Method  ");
		 
		 System.out.println("ID :-- "+id);
		 
		 Optional<User> user=rservice.findById(id);
		 
		 model.addAttribute("UserUpdate", user);
		 
		 return new ModelAndView("updateUser", "command" ,user);
	 }

	 @PostMapping("/updateUser")
	 public String editUserPost(@ModelAttribute("UserUpdate") User user, Map<String, Object> map)
	 {

		 log.info("Registration Controller :---- Edit User POST Method  ");

		rservice.update(user);
					
		map.put("userList", rservice.getUser());

		return "alluser";

	 }

	
	
	
}
