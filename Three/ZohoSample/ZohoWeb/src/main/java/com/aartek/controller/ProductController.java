package com.aartek.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.ProductDTO;
import com.aartek.service.ProductService;
import com.aartek.validator.ProductValidator;

@Controller
public class ProductController {

	
	@Autowired
	private ProductValidator pvalidate;
	
	@Autowired
	private ProductService pservice;
	
	
	@RequestMapping(value="/product", method= {RequestMethod.GET, RequestMethod.POST})
	public String checkProductController(@ModelAttribute("product") ProductDTO product, BindingResult result, Map<String, Object> map, HttpServletRequest request)
	{
		
		System.out.println("\n Inside Product Controller");
		
		map.put("product", product);
		
		map.put("productList", pservice.getAllProductService(product));
		
		
		if(("POST").equals(request.getMethod()))
		{
		
			pvalidate.validate(product, result);
			
			if(result.hasErrors())
			{

				System.out.println("Error Occur");
				
				return "product";
				
			}
			
			else
			{

			pservice.checkProductService(product);	
			
			map.put("productList", pservice.getAllProductService(product));
			
			return "product";
			
			}

		}
	
		return "product";
	}

	
}
