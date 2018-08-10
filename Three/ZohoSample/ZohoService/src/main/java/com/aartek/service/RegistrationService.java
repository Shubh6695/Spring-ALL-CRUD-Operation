package com.aartek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.UserDTO;
import com.aartek.repository.RegistrationRepository;

@Service
public class RegistrationService {

	
	@Autowired
	private RegistrationRepository rrepo;
	
	public void checkRegistration(UserDTO user)
	{
		
		System.out.println("\n Inside Registration Service ");
		
		System.out.println(user.getFname());
		
		System.out.println(user.getLname());
		
		System.out.println(user.getEmail());

		System.out.println(user.getPassword());
	
		System.out.println(user.getMobileno());
	
		rrepo.checkRegistrationRepo(user);
		
	}
	
	
}
