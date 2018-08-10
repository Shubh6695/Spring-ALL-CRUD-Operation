package com.aartek.validator;


import java.util.regex.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.UserDTO;
import com.aartek.repository.RegistrationRepository;

/*Step no:- 12(a) Create a new Package com.aartek.validator */
/*Step no:- 12(b) Create a RegistrationValidator.java class */
/*Step no:- 13(c) add these package in dispatcher-Servlet.xml */

@Component
public class RegistrationValidator implements Validator
{

/* ? means it is generic that accept all the classes at runtime */	
/* supports() indicate that this class is available or NOT */

	@Autowired
	private RegistrationRepository rrepo;
	
	
	private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

	private static final String PASS_REGEX="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
	
	private static Pattern pattern;
	
	private Matcher matcher;
	
	
	public boolean supports(Class<?> user)
	{
		
		return UserDTO.class.isAssignableFrom(user);
		
	}
	
	
	public void validate(Object target, Errors errors)
	{
		
		
		System.out.println("Validate Start");
		
		UserDTO user=(UserDTO) target;
		
		ValidationUtils.rejectIfEmpty(errors,"fname", "error.fname.empty");
		
		ValidationUtils.rejectIfEmpty(errors,"lname", "error.lname.empty");
		
		ValidationUtils.rejectIfEmpty(errors,"email", "error.email.empty");
		
		ValidationUtils.rejectIfEmpty(errors,"password", "error.password.empty");
		
		ValidationUtils.rejectIfEmpty(errors,"mobileno", "error.mobile.empty");
		
		
		if(user.getFname().length() > 50)
		{
			System.out.println("First Name is Small");
			
			errors.rejectValue("fname","error.fname.rule1");
			
		}
		
		
		if(user.getLname().length() > 50)
		{
			System.out.println("Last Name is Small");
			
			errors.rejectValue("lname","error.lname.rule1");
			
		}
		
		
		pattern=Pattern.compile(EMAIL_REGEX);
		
		matcher=pattern.matcher(user.getEmail());
		
		
		if(matcher.matches()!=true)
		{	
			
			errors.rejectValue("email","error.email.rule1");
			
		}
		
		pattern=Pattern.compile(PASS_REGEX);
		
		matcher=pattern.matcher(user.getPassword());
		
				
		if(matcher.matches()!=true)
		{
		
			errors.rejectValue("password", "error.password.rule1");
		
		}
		
		if(user.getMobileno()!=null && user.getMobileno().toString().length() !=10 )
		{
			
			errors.rejectValue("mobileno","error.mobile.rule1");
		}
		
		
		/* Database Transaction */
		
		String email=rrepo.findByEmail(user.getEmail());
		
		if(user.getEmail().equals(email)==true)
		{
			System.out.println("EMAIL ID :-"+email);
			
			errors.rejectValue("email", null, "Email Already Exist");
			
		}
		
		System.out.println("Validate End");
		
	}
	
	
}
