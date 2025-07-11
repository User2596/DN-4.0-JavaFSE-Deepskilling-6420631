package com.cognizant.spring_learn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;

@RestController
public class CountryController {

	public static final Logger logger = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	CountryService countryService;
	
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
	
	@GetMapping("/countries")
	public List<Country> getCountries() {
		logger.info("START - getCountries()");
		List<Country> countries = countryService.getCountries();
		logger.info("END - getCountries()");
		return countries;
	}
	
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) {
		logger.info("START - getCountry({})", code);
		Country country = countryService.getCountry(code);
		logger.info("END - getCountry({})", code);
		return country;
	}
	
}