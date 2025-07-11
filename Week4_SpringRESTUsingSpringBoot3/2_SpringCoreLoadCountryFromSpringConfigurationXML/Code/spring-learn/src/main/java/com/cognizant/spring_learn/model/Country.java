package com.cognizant.spring_learn.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

	private static final Logger logger = LoggerFactory.getLogger(Country.class);
	
	private String code;
	private String name;
	
	public Country() {
		logger.debug("Inside Country Constructor");
	}

	public String getCode() {
		logger.debug("Getting Country Code: {}", code);
		return code;
	}

	public void setCode(String code) {
		logger.debug("Setting Country Code: {}", code);
		this.code = code;
	}

	public String getName() {
		logger.debug("Getting Country Name: {}", name);
		return name;
	}

	public void setName(String name) {
		logger.debug("Setting Country Name: {}", name);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
}
