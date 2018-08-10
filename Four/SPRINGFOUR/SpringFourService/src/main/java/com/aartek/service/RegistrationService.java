package com.aartek.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.Employee;
import com.aartek.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository rrepo;
	
	public Employee registerService(Employee emp)
	{
		
		System.out.println("\n Registration Service :---- Register Service Method \n");
		
		System.out.println(emp.getFirstName()+"\t"+emp.getLastName()+"\t"+emp.getDept()+"\t"+emp.getEmail()+"\t"+emp.getAddress()+"\t"+emp.getMobile());
			
		rrepo.registerRepository(emp);
		
		return emp;
	}
	
	
	public List<Employee> getEmployeeListService(Employee empdata)
	{
		
		System.out.println("\n Registration Service :---- GET Employee List Service Method \n");


		List<Employee> rows=rrepo.getEmployeeList(empdata);
		
/*		Iterator<Employee> itr=rows.iterator();
		
		while(itr.hasNext())
		{
			Employee emp=(Employee) itr.next();
				
			System.out.println(emp.getFirstName()+"\t"+emp.getLastName()+"\t"+emp.getDept()+"\t"+emp.getEmail()+"\t"+emp.getAddress()+"\t"+emp.getMobile());
			
		}
*/
		
		return rows;
		
	}	
	
	
	public void deleteEmployeeService(Integer eid)
	{
		
		System.out.println("\n Registration Service :----  Delete Employee Service Method \n");
		
		rrepo.deleteEmployee(eid);
		
		
	}

	public Employee editEmployeeService(Employee emp)
	{
		
		System.out.println("\n Registration Service :----  Edit Employee Service Method \n");
		
		rrepo.editEmployee(emp);
		
		return emp;
	}

	public Employee getEmployee(Integer eid)
	{

		System.out.println("\n Registration Service :----  GET Employee Method \n");
		
		Employee emp=rrepo.getEmployee(eid);
		
		return emp;

		
	}

	
}
