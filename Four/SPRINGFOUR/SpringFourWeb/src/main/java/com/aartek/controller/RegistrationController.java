package com.aartek.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aartek.model.Employee;
import com.aartek.service.RegistrationService;

@Controller
/*@RequestMapping("/")*/

public class RegistrationController {
	
	@Autowired
	RegistrationService rservice;
	
	
	@RequestMapping(value= { "/registration" }, method=RequestMethod.GET)
	public String listEmployee(Model model)
	{
		model.addAttribute("employee",new Employee());
		System.out.println("REgistration Controller : listEmployee");
		return "registration";	
	}
	
	 @RequestMapping(value="/registration", method=RequestMethod.POST)
	  public String employeeAction(@ModelAttribute("employee")Employee emp)
	 {
		 
			System.out.println("\n Registration Controller :---- Welcome Page Method \n");
			
			
			System.out.println("\n Employee Details");

		  System.out.println(emp.getFirstName()+"\t"+emp.getLastName()+"\t"+emp.getDept()+"\t"+emp.getEmail()+"\t"+emp.getAddress()+"\t"+emp.getMobile());
		  
		  rservice.registerService(emp);
		  
		  return "allemployees";
	  }
	
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
		public String getEmployeeListController(Employee empdata, Map<String, Object> map)
		{
			
			System.out.println("\n Registration Controller :---- GET Employee List Controller Method \n");


			map.put("employeeList", rservice.getEmployeeListService(empdata));
			
			
/*			List<Employee> rows=rservice.getEmployeeListService(empdata);
			
			Iterator<Employee> itr=rows.iterator();
			
			while(itr.hasNext())
			{
				Employee emp=(Employee) itr.next();
					
				System.out.println(emp.getFirstName()+"\t"+emp.getLastName()+"\t"+emp.getDept()+"\t"+emp.getEmail()+"\t"+emp.getAddress()+"\t"+emp.getMobile());
				
			}
*/
			
			return "allemployees";
			
		}	

	 @RequestMapping(value="/delete-{eid}", method=RequestMethod.GET)
	 public String deleteEmployeeDetails(@PathVariable Integer eid)
	 {
		 System.out.println("\n Registration Controller :---- DELETE Employee Details Controller Method \n");
	
		 
		 System.out.println("EID :-- "+eid);

//		 System.out.println(emp.getFirstName()+"\t"+emp.getLastName()+"\t"+emp.getDept()+"\t"+emp.getEmail()+"\t"+emp.getAddress()+"\t"+emp.getMobile());
		 
		 rservice.deleteEmployeeService(eid);
		 
		 return "allemployees";
	 }

	 
	 @RequestMapping(value="/edit-{eid}", method=RequestMethod.GET)
	 public ModelAndView editEmployeeDetails(@PathVariable Integer eid, Model model)
	 {

		 System.out.println("\n Registration Controller :---- EDIT Employee Details Controller Method \n");
		 
		 System.out.println("EID :-- "+eid);
		 
		 		 
		 Employee emp= rservice.getEmployee(eid);
		 
		 model.addAttribute("employee", emp);
		 
		 return new ModelAndView("update", "command", emp);
	 }
	 

	 @RequestMapping(value="/update", method=RequestMethod.POST)
	 public String updateEmployeeDetails(@ModelAttribute("employee") Employee emp)
	 {

		 System.out.println("\n Registration Controller :---- Update Employee Details Controller Method \n");
		 
		 System.out.println("EID :-- "+emp.getId());
		 

		 rservice.editEmployeeService(emp);
		 
		 
		 return "allemployees";
	 }

	 
	 
}


