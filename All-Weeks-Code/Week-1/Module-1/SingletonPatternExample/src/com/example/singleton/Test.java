package com.example.singleton;

public class Test {

	public static void main(String[] args) {
		
		Logger l1 = Logger.getInstance();
		Logger l2 = Logger.getInstance();
		
		l1.log("Instance 1 is running...");
		l2.log("Instance 2 is running...");
		System.out.println();
		
		if (l1==l2) {
			System.out.println("Both instances are the same");
		} else {
			System.out.println("Two different instances created");
		}
		
	}

}
