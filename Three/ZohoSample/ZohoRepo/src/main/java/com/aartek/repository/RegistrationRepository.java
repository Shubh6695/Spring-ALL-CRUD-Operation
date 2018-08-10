package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.UserDTO;

@Repository
public class RegistrationRepository {

	@Autowired
	private HibernateTemplate HBTemplate;
	
	
	public void checkRegistrationRepo(UserDTO user)
	{
		
		System.out.println("\n Inside Registration Repository");

		HBTemplate.save(user);
		
		System.out.println("Record Insert Successfully");
		
	}
	
	public String findByEmail(String email)
	{
		String checkmailid=null;
		
		List<UserDTO> list=HBTemplate.find("from UserDTO u where u.email=?" , email);
		
		Iterator<UserDTO> itr=list.iterator();
		
		while(itr.hasNext())
		{
			UserDTO user=(UserDTO)itr.next();
			
			checkmailid=user.getEmail();
		}
		
		return checkmailid;
	}
	
	
	
}
