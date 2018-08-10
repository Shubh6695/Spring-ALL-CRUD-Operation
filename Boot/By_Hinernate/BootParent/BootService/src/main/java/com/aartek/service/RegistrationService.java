package com.aartek.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aartek.model.User;
import com.aartek.repository.RegistrationRepo;

@Service
public class RegistrationService {

	
	private static final Logger log=Logger.getLogger(RegistrationService.class);
	
	
	@Autowired
	private RegistrationRepo rrepo;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public String saveUser(User user)
	{
		
		
		log.warn("Registration Service :---- Save User Method");
		
		rrepo.saveUser(user);
		
		return "registration";
	}
	

	@Transactional(propagation=Propagation.REQUIRED)
	public List<User> getAllUser(User user)
	{
		log.warn("Registration Service :---- GET ALL User Method");
				
		List<User> list=rrepo.getAllUser(user);
		
		return list;
	}
	

	@Transactional(propagation=Propagation.REQUIRED)
	public User getSingleUser(Integer id)
	{
		log.warn("Registration Service :---- GET Single User Method");
				
		User user=rrepo.getSingleUser(id);
	
		return user;
	}

	
	@Transactional(propagation=Propagation.REQUIRED)
	public User deleteUserService(Integer id)
	{
		log.warn("Registration Service :---- Delete User Service Method");
		
		User user=rrepo.deleteSingleUser(id);
		
		return user;
	}	

	@Transactional(propagation=Propagation.REQUIRED)
	public User editUser(User user)
	{
		log.warn("Registration Service :---- Edit User Method");
		
		rrepo.editUser(user);
		
		return user;
	}
	
	
}

