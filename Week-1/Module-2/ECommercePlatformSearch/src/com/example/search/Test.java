package com.example.search;

public class Test {

	public static void main(String[] args) {
		
		Product[] products = {
				new Product(100, "Keyboard", "Electronics"),
		        new Product(104, "Mouse", "Electronics"),
		        new Product(102, "Shirt", "Clothings"),
		        new Product(107, "Pepsi", "Beverages"),
		        new Product(105, "Ball", "Sports"),
				new Product(101, "Pen", "Accessories")
		};
		
		Product[] sortedProducts = new SortedInventory().productArraySorted(products);
		
		for (Product product : sortedProducts) {
			System.out.println(product.toString());
		}
		System.out.println();
		
		SearchAlgo linear = new LinearSearch();
		SearchAlgo binary = new BinarySearch();
		
		System.out.print("Product with ID 105 (Linear Search): ");
		Product p1 = linear.search(products, 105);
		System.out.println(p1!=null ? p1.toString() : "Not found");
		
		System.out.print("Product with ID 103 (Linear Search): ");
		Product p4 = linear.search(products, 103);
		System.out.println(p4!=null ? p4.toString() : "Not found");
		
		System.out.print("Product with ID 106 (Binary Search): ");
		Product p2 = binary.search(sortedProducts, 106);
		System.out.println(p2!=null ? p2.toString() : "Not found");
		
		System.out.print("Product with ID 101 (Binary Search): ");
		Product p3 = binary.search(sortedProducts, 101);
		System.out.println(p3!=null ? p3.toString() : "Not found");
		
	}

}
