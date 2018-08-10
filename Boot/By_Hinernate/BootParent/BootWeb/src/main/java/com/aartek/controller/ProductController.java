package com.aartek.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aartek.model.Product;
import com.aartek.model.User;
import com.aartek.service.LoginService;
import com.aartek.service.ProductService;

@Controller
public class ProductController {

	private static final Logger log=Logger.getLogger(ProductController.class);

	
	@Autowired
	private ProductService pservice;
	

	@RequestMapping(value="/product", method=RequestMethod.GET)
	public String getProduct(@ModelAttribute("UserProduct") Product product, Map<String, Object> map )
	{
		
		log.info("Product Controller :---- GET Product GET Method  ");
		
		map.put("UserProduct", new Product());
		
		map.put("productList", pservice.getAllProduct(product));
	
		return "product";
	}	

	
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("UserProduct") Product product, Map<String, Object> map )
	{
		
		 log.info("Product Controller :---- Save Product POST Method  ");
		
		pservice.saveProduct(product);
		
		map.put("productList", pservice.getAllProduct(product));
	
		return "redirect:/product";
	}	
	
	
	 @RequestMapping(value="/deleteproduct-{pid}", method=RequestMethod.GET)
	 public String deleteProductDetails(@PathVariable Integer pid, Map<String, Object> map)
	 {
		 log.info("Product Controller :---- Delete Product GET Method  ");
	
		 System.out.println("\n\n Product Controller :---- Delete Product GET Method  \n\n");
		 
		 System.out.println("ID :-- "+pid);
		 
		 Product product=pservice.deleteProduct(pid);

		 map.put("productList", pservice.getAllProduct(product));
		 
		 return "redirect:/product";
	 }

	
	 @RequestMapping(value="/editproduct-{pid}", method=RequestMethod.GET)
	 public ModelAndView editProductGet(@PathVariable Integer pid, Model model)
	 {
		 log.info("Product Controller :---- EDIT Product GET Method  ");
		 
		 System.out.println("ID :-- "+pid);
		 
		 Product product=pservice.getSingleProduct(pid);
		 
		 model.addAttribute("UserProduct", product);
		 
		 return new ModelAndView("updateProduct", "command" ,product);
		 
	 }

	 
	 
	 @RequestMapping(value="/updateProduct", method=RequestMethod.POST)
	 public String editProductPost(@ModelAttribute("UserProduct") Product product, Map<String, Object> map)
	 {
		 log.info("Product Controller :---- EDIT Product POST Method  ");
		 
		 System.out.println("ID :-- "+product.getPid());
		 
		 pservice.editProduct(product);
		 
		 map.put("productList", pservice.getAllProduct(product));
		 
		 return "redirect:/product";
		 
	 }

	 
}
