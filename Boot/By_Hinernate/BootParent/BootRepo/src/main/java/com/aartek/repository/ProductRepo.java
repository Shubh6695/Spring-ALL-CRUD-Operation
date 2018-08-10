package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.aartek.model.Product;
import com.aartek.model.User;


@Repository
public class ProductRepo {

	
	private static final Logger log=Logger.getLogger(ProductRepo.class);

	@Autowired
	private HibernateTemplate hbtemplate;
	
	
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public String saveProduct(Product product)
	{
		
		log.debug("Product Repository :---- Save Product Method");
		
		hbtemplate.save(product);
		
		log.debug("\n Record Inserted Successfully \n");
		
		return "product";

		
	}

	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
	public List getAllProduct(Product product)
	{
		
		log.debug("Product Repository :---- GET ALL Product Method");
		
		List rows=hbtemplate.loadAll(Product.class);
		
		log.debug("\n Record Fetched Successfully \n");
		
		return rows;
	}
	
	
	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
	public Product getSingleProduct(Integer id)
	{
		log.debug("Product Repository :---- GET ALL Product Method");
		
		List rows= hbtemplate.find("from Product P where P.id = ?", id);
				
		Iterator<Product> itr=rows.iterator();
		
		Product product=null;
		
		while(itr.hasNext())
		{
			
			product=(Product) itr.next();
		}
		
		log.debug("\n Record Fetched Successfully \n");
		
		return product;
	}

	
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public Product deleteSingleProduct(Integer id)
	{
		
		log.debug("Product Repository :---- Delete Single Product Method");
		
		Product product=getSingleProduct(id); /* Getting the User*/ 
		
		hbtemplate.delete(product);

		log.debug("\n Record Delete Successfully \n");
		
		return product;
	}

	
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public Product editProduct(Product product)
	{
		log.debug("Product Repository :---- Edit Single Product Method");
		
		hbtemplate.update(product);
		
		return product;
	}
	
	
}
