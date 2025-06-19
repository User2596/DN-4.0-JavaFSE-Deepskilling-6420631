package com.example.search;

import java.util.Arrays;

public class SortedInventory {
	
	public Product[] productArraySorted(Product[] products) {
		
		Arrays.sort(products, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));
		return products;
	
	}

}