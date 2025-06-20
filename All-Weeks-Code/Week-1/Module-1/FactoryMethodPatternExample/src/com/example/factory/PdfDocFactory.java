package com.example.factory;

public class PdfDocFactory extends DocumentFactory<PdfDocument> {

	@Override
	public PdfDocument createDocument() {

		System.out.println("New pdf document created");
		return new PdfDocClass();
		
	}

}
