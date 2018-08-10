package com.aartek.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.ProductDTO;
import com.aartek.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository prepo;
	
	
	public void checkProductService(ProductDTO product)
	{
		
		System.out.println("\n Inside Product Service");

		System.out.println(product.getPname()+"\t"+product.getPdescription()+"\t"+product.getPprice());
		
		prepo.checkProductRepo(product);
		
	}

	
	public List<ProductDTO> getAllProductService(ProductDTO product)
	{
		
		System.out.println("Inside Product Service");
		
		List<ProductDTO> rows=prepo.getAllProductRepo(product);
		
		Iterator<ProductDTO> itr=rows.iterator();
		
		while(itr.hasNext())
		{
			ProductDTO pdto=(ProductDTO) itr.next();
				
			System.out.println(pdto.getPid()+"\t"+pdto.getPname()+"\t"+pdto.getPdescription()+"\t"+pdto.getPprice());
			
		}
		
		Object obj=(Object) rows;
		
		
		return rows;
	}
	
	
	
	
}
