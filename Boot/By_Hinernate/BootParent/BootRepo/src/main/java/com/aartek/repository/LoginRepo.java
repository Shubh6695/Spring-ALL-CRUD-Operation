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
public class LoginRepo {

	private static final Logger log=Logger.getLogger(LoginRepo.class);
	
	@Autowired
	private HibernateTemplate hbtemplate;
	
	
	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
	public User checkLogin(String email, String password)
	{
		
		log.debug("Login Repository :---- Check Login Method");
		
				
		List rows =hbtemplate.find("from User U where U.email = ? and U.password = ?", email , password);
		
		User user=null;
		
		Iterator<User> itr=rows.iterator();

		while(itr.hasNext())
		{
			user=(User)itr.next();
			
		}
		
		log.debug("\n Record Fetched Successfully \n");
		
		return user;
	}

	
}
