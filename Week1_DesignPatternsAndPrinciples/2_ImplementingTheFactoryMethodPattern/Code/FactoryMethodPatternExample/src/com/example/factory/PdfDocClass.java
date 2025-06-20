package com.example.factory;

public class PdfDocClass implements PdfDocument {
	
	@Override
	public void open(String filename) {
		
		System.out.println("Pdf file opened: " + filename);
		
	}
	
}
