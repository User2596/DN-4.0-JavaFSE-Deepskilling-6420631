package com.example.recursion;

/*
 * Assuming formula futureForecast = presentValue * (1 + growthRate) ^ timePeriod
 * 
 * We assume Compound growth over years at a steady rate based on past data
 */

public class FinancialForecaster {

	public double futureForecast(double presentValue, double growthRate, int timePeriod) {
		
		if (timePeriod <= 0) {
			
			return presentValue;
		
		}
		
		return futureForecast(presentValue, growthRate, (timePeriod - 1)) * (1 + growthRate);
		
	}
	
}
