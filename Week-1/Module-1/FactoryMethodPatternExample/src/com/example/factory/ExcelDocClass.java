package com.example.factory;

public class ExcelDocClass implements ExcelDocument {
	
	@Override
	public void open(String filename) {

		System.out.println("Excel file opened: " + filename);
		
	}
	
}
