package com.aartek.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.User;
import com.aartek.repositoryInterface.RegistrationRepoInterfcae;
import com.aartek.serviceInterface.RegistrationServiceInterface;


@Service
@Transactional
public class RegistrationImpl implements RegistrationServiceInterface 
{

	
	private static final Logger log=Logger.getLogger(RegistrationImpl.class);

	@Autowired
	private RegistrationRepoInterfcae rrepo;
	
	
	public void createUser(User user) 
	{
		log.warn("Registration Service :---- Create User Method");
		
		rrepo.save(user);
		
	}

	public List<User> getUser() {
		
		List list=(List) rrepo.findAll();
		
		return list;
	}

	public Optional<User> findById(Integer id) {
	
		Optional<User> user=rrepo.findById(id);
		
		return user;
	}

	public void update(User user) {
		
		rrepo.save(user);	
		
		//return null;
	}

	public void deleteUserById(Integer id) {
		
		rrepo.deleteById(id);
		
		
	}

	public User updatePartially(User user, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
