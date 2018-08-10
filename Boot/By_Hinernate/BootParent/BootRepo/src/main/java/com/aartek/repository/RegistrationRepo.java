package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.aartek.model.User;

@Repository
public class RegistrationRepo {

	private static final Logger log=Logger.getLogger(RegistrationRepo.class);
	
	@Autowired
	private HibernateTemplate hbtemplate;
	
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public String saveUser(User user)
	{
		log.debug("Registration Repository :---- Save User Method");
		
		hbtemplate.saveOrUpdate(user);
		
		//hbtemplate.save(user);
		
		log.debug("\n Record Inserted Successfully \n");
		
		return "registration";
	}
	
	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
	public List<User> getAllUser(User user)
	{
		log.debug("Registration Repository :---- GET ALL User Method");
		
		List<User> list=hbtemplate.loadAll(User.class);
	
		log.debug("\n Record Fetched Successfully \n");
		
		return list;
	}
	

	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
	public User getSingleUser(Integer id)
	{
		log.debug("Registration Repository :---- GET Single User Method");
		
		List rows= hbtemplate.find("from User U where U.id = ?", id);
				
		Iterator<User> itr=rows.iterator();
		
		User user=null;
		
		while(itr.hasNext())
		{
			
			user=(User) itr.next();
		}
		
		log.debug("\n Record Fetched Successfully \n");
		
		return user;
	}

	
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public User deleteSingleUser(Integer id)
	{
		
		log.debug("Registration Repository :---- Delete Single User Method");
		
		User user=getSingleUser(id); /* Getting the User*/ 
		
		hbtemplate.delete(user);

		log.debug("\n Record Delete Successfully \n");
		
		return user;
	}
	

	@Transactional(isolation=Isolation.READ_COMMITTED)
	public User editUser(User user)
	{
		
		log.debug("Registration Repository :---- Edit Single User Method");
		
	
		hbtemplate.update(user);

		log.debug("\n Record Update Successfully \n");
		
		return user;
	}



}
