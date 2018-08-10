package com.aartek.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.aartek.model.Employee;


@Repository
public class RegistrationRepository {

/*	@Autowired
	private SessionFactory sessionFactory;
*/
	@Autowired
	private HibernateTemplate hbtemplate;
	
	@Transactional(readOnly=false)
	public Employee registerRepository(Employee emp)
	{
		
		System.out.println("\n Registration Repository :---- Register Repository Method \n");
		
		System.out.println(emp.getFirstName()+"\t"+emp.getLastName()+"\t"+emp.getDept()+"\t"+emp.getEmail()+"\t"+emp.getAddress()+"\t"+emp.getMobile());
			
	//	Session sess=sessionFactory.getCurrentSession();
		
	//	sess.persist(emp);
		
		hbtemplate.save(emp);
		
		System.out.println("\n Insert Successfully");
		
		return emp;
	}

	public List<Employee> getEmployeeList(Employee empdata)
	{
		
		System.out.println("\n Registration Repository :---- GET Employee List Method \n");
		
		List<Employee> rows=hbtemplate.loadAll(Employee.class);
		
/*		Iterator<Employee> itr=rows.iterator();
		
		while(itr.hasNext())
		{
			Employee emp=(Employee) itr.next();
				
			System.out.println(emp.getFirstName()+"\t"+emp.getLastName()+"\t"+emp.getDept()+"\t"+emp.getEmail()+"\t"+emp.getAddress()+"\t"+emp.getMobile());
			
		}
*/
		
		
		return rows;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public void deleteEmployee(Integer eid)
	{
		
		System.out.println("\n Registration Repository :----  Delete Employee Method \n");
		
		System.out.println(" \n Registration Repository EID :-- "+eid);

	
		List rows=hbtemplate.find("from Employee E where E.id = ?", eid);
		
		Iterator<Employee> itr=rows.iterator();
		
		while(itr.hasNext())
		{
			Employee emp=(Employee) itr.next();
				
			System.out.println(emp.getFirstName()+"\t"+emp.getLastName()+"\t"+emp.getDept()+"\t"+emp.getEmail()+"\t"+emp.getAddress()+"\t"+emp.getMobile());
			
			hbtemplate.delete(emp);
		
		}
			
		System.out.println("Delete Successfully");
		
	}
	
	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
	public Employee getEmployee(Integer eid)
	{
		
		System.out.println("\n Registration Repository :----  GET Employee Method \n");
		
		System.out.println(" \n Registration Repository EID :-- "+eid);


		List rows=hbtemplate.find("from Employee E where E.id = ?", eid);
		
		Iterator<Employee> itr=rows.iterator();
		
		Employee emp=null;
		
		while(itr.hasNext())
		{
			emp=(Employee) itr.next();
				
			System.out.println(emp.getFirstName()+"\t"+emp.getLastName()+"\t"+emp.getDept()+"\t"+emp.getEmail()+"\t"+emp.getAddress()+"\t"+emp.getMobile());
			
		}
		
	
	return emp;
	}

	
	
	@Transactional(readOnly=false)
	public Employee editEmployee(Employee emp)
	{
		
		System.out.println("\n Registration Repository :----  EDIT Employee Method \n");
		
		
		hbtemplate.update(emp);

		System.out.println("Update Successfully");
		
	
	return emp;
	}

	
}
