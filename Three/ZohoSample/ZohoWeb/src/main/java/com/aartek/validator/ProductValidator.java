package com.aartek.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.ProductDTO;

@Component
public class ProductValidator implements Validator {

	
	public boolean supports(Class<?> product)
	{
		
		return ProductDTO.class.isAssignableFrom(product);
		
	}
	
	public void validate(Object target, Errors errors)
	{
		
		System.out.println("Validate Start");

		
		ProductDTO product=(ProductDTO) target;
		
		
		ValidationUtils.rejectIfEmpty(errors, "pname", "errors.pname", "Please Insert Product Name");

		ValidationUtils.rejectIfEmpty(errors, "pdescription", "errors.pdescription", "Please Insert Product Description");

		ValidationUtils.rejectIfEmpty(errors,"pprice", "errors.pprice", "Please Insert Product Price");
		
		

		System.out.println("Validate End");
	}	
	
	
}
