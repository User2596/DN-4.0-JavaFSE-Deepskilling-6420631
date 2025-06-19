package com.example.recursion;

public class Forecaster {

	private double futureValue;
	
	public void Forecast(double presentValue, double growthRate, int timePeriod) {
	
		FinancialForecaster future = new FinancialForecaster();
		futureValue = future.futureForecast(presentValue, growthRate, timePeriod);
		
		System.out.println("After " + timePeriod + " years, " + 
		 String.format("%.2f", presentValue) + " rupees at " +
		 String.format("%.2f", (growthRate * 100)) + "% growthRate would become " +
		 String.format("%.2f", futureValue) + " rupees");
		System.out.println();
	
	}

}