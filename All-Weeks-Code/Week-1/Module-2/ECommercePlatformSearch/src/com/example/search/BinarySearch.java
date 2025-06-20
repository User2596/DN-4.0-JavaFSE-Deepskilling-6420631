package com.example.search;

public class BinarySearch implements SearchAlgo {

	@Override
	public Product search(Product[] products, int key) {

		return search(products, key, 0, (products.length - 1));

	}

	public Product search(Product[] products, int key, int low, int high) {

		if (high >= low) {

			int mid = (low+high)/2;
			
			if (products[mid].getProductId() == key) {
				return products[mid];
			} 
			else if (products[mid].getProductId() > key) {
				return search(products, key, low, (mid-1));
			}
			else {
				return search(products, key, (mid+1), high);
			}
		
		}
		
		return null;
		
	}

}
