package com.example.JUnitProject4;

public class Calculator {
    
	public int add(int num1, int num2) {
		return (num1 + num2);
	}
	
	public int subtract(int num1, int num2) {
		return (num1 - num2);
	}
	
	public int multiply(int num1, int num2) {
		return (num1 * num2);
	}
	
	public int divide(int num1, int num2) {
		return (num1 / num2);
	}
	
	public int modulo(int num1, int num2) {
		return (num1 % num2);
	}
	
	public int factorial(int num) {
		if (num == 0) {
			return 1;
		}
		return (num * factorial(num-1));
	}
	
}
