package com.example.factory;

public class Test {

	public static void main(String[] args) {
		
		DocumentFactory<WordDocument> wordFac = new WordDocFactory();
		DocumentFactory<PdfDocument> pdfFac = new PdfDocFactory();
		DocumentFactory<ExcelDocument> excelFac = new ExcelDocFactory();
		
		WordDocument file1 = (WordDocument) wordFac.createDocument();
		file1.open("file1.docx");
		System.out.println();
		
		PdfDocument file2 = (PdfDocument) pdfFac.createDocument();
		file2.open("file2.pdf");
		System.out.println();
		
		ExcelDocument file3 = (ExcelDocument) excelFac.createDocument();
		file3.open("file3.xlsx");
		System.out.println();
		
	}

}
