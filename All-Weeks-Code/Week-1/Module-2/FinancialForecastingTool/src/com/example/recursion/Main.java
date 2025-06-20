package com.example.recursion;

public class Main {

	public static void main(String[] args) {
		
		Forecaster fin = new Forecaster();
		
		fin.forecast(25482.46, 0.0695, 13);
		fin.forecast(40000, 0.07, 4);
		fin.forecast(212491.73, 0.0326, 25);
		fin.forecast(18392.14, 0.0839, 11);
		
	}

}
