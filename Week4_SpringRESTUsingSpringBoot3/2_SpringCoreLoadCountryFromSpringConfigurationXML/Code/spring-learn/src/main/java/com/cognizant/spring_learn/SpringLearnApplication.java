package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring_learn.model.Country;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public static void main(String[] args) {
		logger.info("START");
		SpringApplication.run(SpringLearnApplication.class, args);
		displayCountry();
		logger.info("END");
	}
	
	public static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		logger.debug("Country: {}", country.toString());
	}

}
