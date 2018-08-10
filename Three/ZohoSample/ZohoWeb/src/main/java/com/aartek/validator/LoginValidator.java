package com.aartek.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.UserDTO;
import com.aartek.repository.LoginRepository;

@Component
public class LoginValidator implements Validator {

	private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

	private static Pattern pattern;

	private Matcher matcher;

	public boolean supports(Class<?> user) {

		return UserDTO.class.isAssignableFrom(user);

	}

	public void validate(Object target, Errors errors) {

		System.out.println("Login Validate Start");

		UserDTO user = (UserDTO) target;
		
		ValidationUtils.rejectIfEmpty(errors,"email", "error.email.empty");

		ValidationUtils.rejectIfEmpty(errors,"password", "error.password.empty");

		pattern = Pattern.compile(EMAIL_REGEX);

		matcher = pattern.matcher(user.getEmail());

		if (matcher.matches() != true) {

			System.out.println("Inside Mathcher");
			
			errors.rejectValue("email","error.email.rule1");

		}
		
		System.out.println("Login Validation End");

	}

	
}
