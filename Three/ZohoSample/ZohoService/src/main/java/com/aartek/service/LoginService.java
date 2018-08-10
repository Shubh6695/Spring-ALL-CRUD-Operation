package com.aartek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.UserDTO;
import com.aartek.repository.LoginRepository;

/*Step no:- 10(a) Create LoginService Class*/

@Service
public class LoginService {

	
	@Autowired
	private LoginRepository lrepo;
	
	public void checklogin(UserDTO user)
	{
		
		System.out.println("Inside Login Service Class \n");		
	
		System.out.println("Login Service :- "+user.getEmail());
	
		System.out.println("Login Service :- "+user.getPassword());
		
		lrepo.checkLoginRepo(user);
		
		
	}
	
	public boolean checkLoginDemo(UserDTO user)
	{
		
		boolean list=lrepo.checkLogin(user);
		
		return list;
				
	}
	
	
	
	
}
