package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.ProductDTO;

@Repository
public class ProductRepository {

	@Autowired
	private HibernateTemplate HBTemplate;
	
	public void checkProductRepo(ProductDTO product)
	{
		
		System.out.println("\n Inside Product Repository");

		System.out.println(product.getPname()+"\t"+product.getPdescription()+"\t"+product.getPprice());
		
		HBTemplate.save(product);	
	
		System.out.println("Record Inserted Successfully");
	
	}
	
	
	public List<ProductDTO> getAllProductRepo(ProductDTO product)
	{
		
		System.out.println("Inside Product Repository");
		
		List<ProductDTO> rows=HBTemplate.find("from ProductDTO");
		
		Iterator<ProductDTO> itr=rows.iterator();
		
		while(itr.hasNext())
		{
			ProductDTO pdto=(ProductDTO) itr.next();
				
			System.out.println(pdto.getPid()+"\t"+pdto.getPname()+"\t"+pdto.getPdescription()+"\t"+pdto.getPprice());
			
		}
		
		return rows;
	}
	
	
	
}
