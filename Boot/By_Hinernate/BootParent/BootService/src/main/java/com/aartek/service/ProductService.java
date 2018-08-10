package com.aartek.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aartek.model.Product;
import com.aartek.model.User;
import com.aartek.repository.ProductRepo;

@Service
public class ProductService {

	
	private static final Logger log=Logger.getLogger(ProductService.class);
	
	
	@Autowired
	private ProductRepo prepo;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public String saveProduct(Product product)
	{
		
		
		log.warn("Product Service :---- Save Product Method");
		
		prepo.saveProduct(product);
		
		return "product";
	}


	@Transactional(propagation=Propagation.REQUIRED)
	public List getAllProduct(Product product)
	{
		log.warn("Product Service :---- Save Product Method");
		
		List rows=prepo.getAllProduct(product);
		
		return rows;
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Product deleteProduct(Integer id)
	{
		log.warn("Product Service :---- Delete Single Product Method");
		
		Product product=prepo.deleteSingleProduct(id);
		
		return product;
	}	


	@Transactional(propagation=Propagation.REQUIRED)
	public Product getSingleProduct(Integer pid)
	{
		
		log.warn("Product Service :---- GET Single Product Method");
		
		Product product=prepo.getSingleProduct(pid);
				
		return product;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Product editProduct(Product product)
	{
		
		log.warn("Product Service :---- Edit Product Method");
		
		prepo.editProduct(product);		
		
		return product;
	}

	
	
	
}
