package com.aartek.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aartek.model.User;
import com.aartek.repository.LoginRepo;

@Service
public class LoginService {

	
	private static final Logger log=Logger.getLogger(LoginService.class);

	@Autowired
	private LoginRepo lrepo;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean checkLogin(String email, String password)
	{

		log.warn("Login Service :---- Check Login Method");
		
		User user=lrepo.checkLogin(email, password);
		
		boolean status=false;
		
		if(user!=null)
		{
			status=true;
			
			return status;
		}
		else
		{
		
		return status;
		}	
	}	
	
	
}
