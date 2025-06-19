package com.example.search;

public class LinearSearch implements SearchAlgo {

	@Override
	public Product search(Product[] products, int key) {
		
		for (Product product : products) {
			if (product.getProductId() == key) {
				return product;
			}
		}
		
		return null;
	}

}
