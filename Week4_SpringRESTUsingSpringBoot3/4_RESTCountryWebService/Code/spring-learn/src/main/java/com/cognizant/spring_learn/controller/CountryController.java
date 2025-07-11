package com.cognizant.spring_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.model.Country;

@RestController
public class CountryController {

	public static final Logger logger = LoggerFactory.getLogger(CountryController.class);
	
	@GetMapping("/hello")
	public String sayHello() {
		logger.info("START - sayHello()");
		String message = "Hello World!!";
		logger.info("END - sayHello()");
		return message;
	}
	
	@GetMapping("/country")
	public Country getCountryIndia() {
		logger.info("START - getCountryIndia()");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("in");
		
		logger.info("END - getCountryIndia()");
		return country;
	}
	
}