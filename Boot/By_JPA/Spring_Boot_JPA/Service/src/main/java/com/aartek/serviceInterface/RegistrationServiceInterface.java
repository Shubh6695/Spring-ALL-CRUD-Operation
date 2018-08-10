package com.aartek.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.aartek.model.User;

public interface RegistrationServiceInterface 
{

		public void createUser(User user);
	   
	    public List<User> getUser();
	   
	    public Optional<User> findById(Integer id);
	    
	    public void update(User user);
	    
	    public void deleteUserById(Integer id);
	    
	    public User updatePartially(User user, Integer id);


	
}
