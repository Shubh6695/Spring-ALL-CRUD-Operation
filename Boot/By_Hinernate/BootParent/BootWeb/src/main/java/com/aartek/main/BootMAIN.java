package com.aartek.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.aartek")									// Base Package
public class BootMAIN //extends SpringBootServletInitializer
{

	public static void main(String[] args)
	{
		
		SpringApplication.run(BootMAIN.class, args);
		
		System.out.println("Hello Main Class");
		
	}
	
	
}
