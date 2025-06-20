package com.example.factory;

public class WordDocClass implements WordDocument {
	
	@Override
	public void open(String filename) {
		
		System.out.println("Word file opened: " + filename);
		
	}

}
