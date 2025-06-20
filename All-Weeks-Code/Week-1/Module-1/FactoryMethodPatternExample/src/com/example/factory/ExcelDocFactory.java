package com.example.factory;

public class ExcelDocFactory extends DocumentFactory<ExcelDocument> {

	@Override
	public ExcelDocument createDocument() {
		
		System.out.println("New excel document created");
		return new ExcelDocClass();
		
	}
	
}
