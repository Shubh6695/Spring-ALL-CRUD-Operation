package com.aartek.controller;

import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.UserDTO;
import com.aartek.service.LoginService;
import com.aartek.validator.LoginValidator;

/*Step no:- 7 Create Login Controller Class */
@Controller
public class LoginController {

	
	@Autowired
	private LoginValidator lvalidate;
	 
	@Autowired
	private LoginService lservice;

	
	/*
	 * @RequestMapping("/login") public String showlogin(Map<String , Object> map) {
	 * System.out.println("Inside Controller ShowLogin Method");
	 * 
	 * Step no:- 9(a) create object of UserDTO before jsp load
	 * 
	 * map.put("UserMap", new UserDTO());
	 * 
	 * return "login";
	 * 
	 * }
	 * 
	 * Step no:- 9(d) create POST method
	 * 
	 * @RequestMapping(value ="/login" , method=RequestMethod.POST) public String
	 * showInAction(@ModelAttribute("UserMap") UserDTO user, BindingResult result) {
	 * 
	 * System.out.println("Inside Controller ShowInAction Method");
	 * 
	 * // lvalidate.validate(user, result);
	 * 
	 * if(result.hasErrors()) {
	 * 
	 * return "login";
	 * 
	 * }
	 * 
	 * else {
	 * 
	 * System.out.println(user.getEmail());
	 * 
	 * System.out.println(user.getPassword());
	 * 
	 * 
	 * lservice.checklogin(user);
	 * 
	 * return "login";
	 * 
	 * } }
	 */

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String showloginmethod(@ModelAttribute("UserMap") UserDTO user, BindingResult result,
			Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {

		System.out.println("Show login Method");

		if (("GET").equals(request.getMethod())) {

			System.out.println("Inside Get Method");

			map.put("UserMap", new UserDTO());

			return "login";

		} else {
			
			 lvalidate.validate(user, result);
			 
			if (result.hasErrors()) {

				return "login";

			}

			else {

				System.out.println("Inside Post Method");

				System.out.println(user.getEmail());

				System.out.println(user.getPassword());

				// lservice.checklogin(user);

				boolean list = lservice.checkLoginDemo(user);

				System.out.println("LIST :- " + list);

				if (list == true) {

					System.out.println("if Part");

					try {
					
						
						request.getSession().setAttribute("USERS", user);				// Setting the Session
						
						response.sendRedirect("product.do");
					}

					catch (Exception e) {
						System.out.println("Exception Occur");

					}
				} else {
					System.out.println("Else Part");

					return "login";

				}

			}

		}

		map.put("UserMap", user);

		return "login";
	}

}
