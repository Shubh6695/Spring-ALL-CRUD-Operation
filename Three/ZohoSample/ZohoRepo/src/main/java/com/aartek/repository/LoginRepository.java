package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.UserDTO;

/*Step no:- 10(b) Create LoginRepository Class*/

@Repository
public class LoginRepository {

	@Autowired
	private HibernateTemplate HBTemplate;
	
	
	public void checkLoginRepo(UserDTO user)
	{
		System.out.println("Inside Login Repository Class \n");

/*		Step no:- 11(b) write HQL Query*/
		
		List<UserDTO> rows =HBTemplate.find("from UserDTO U where U.email = ? and U.password = ?", user.getEmail(), user.getPassword());
	
		
		
		Iterator<UserDTO> itr=rows.iterator();

		while(itr.hasNext())
		{
			UserDTO udto=(UserDTO) itr.next();
			
		System.out.println("Login Repository :- "+udto.getEmail());
		
		System.out.println("Login Repository :- "+udto.getPassword());
		
		System.out.println(udto.getFname()+"\t"+udto.getLname()+"\t"+udto.getMobileno());
		
		
		}
	
	
	}

	
	public boolean checkLogin(UserDTO user)
	{
		
		
		List<UserDTO> rows =HBTemplate.find("from UserDTO U where U.email = ? and U.password = ?", user.getEmail(), user.getPassword());
		
		if(rows!= null)
		{
			System.out.println("Inside If Repo");
			
			return true;
			
		}
		else
		{
			return false;
			
		}
		
	}

	
}
