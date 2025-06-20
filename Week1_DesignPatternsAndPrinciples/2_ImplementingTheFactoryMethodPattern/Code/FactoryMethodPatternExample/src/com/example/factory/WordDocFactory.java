package com.example.factory;

public class WordDocFactory extends DocumentFactory<WordDocument> {

	@Override
	public WordDocument createDocument() {

		System.out.println("New word document created");
		return new WordDocClass();
		
	}

}
