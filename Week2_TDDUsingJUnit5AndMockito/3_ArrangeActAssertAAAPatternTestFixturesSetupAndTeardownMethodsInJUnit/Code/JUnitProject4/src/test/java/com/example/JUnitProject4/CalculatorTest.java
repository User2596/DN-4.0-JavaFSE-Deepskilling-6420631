package com.example.JUnitProject4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calc;
	
	@Before
	public void setUp() {
		calc = new Calculator();
	}
	
	@After
	public void tearDown() {
		calc = null;
	}
	
	@Test
    public void testAdd() {
        // Arrange
		int a = 5;
        int b = 8;
        
        // Act
        int result = calc.add(a, b);
        
        //Assert
        assertEquals(13, result); 
    }
	
	@Test
    public void testSubtract() {
        // Arrange
		int a = 11;
        int b = 13;
        
        // Act
        int result = calc.subtract(a, b);
        
        //Assert
        assertEquals(-2, result); 
    }
	
	@Test
    public void testMultiply() {
        // Arrange
		int a = 7;
        int b = 6;
        
        // Act
        int result = calc.multiply(a, b);
        
        //Assert
        assertEquals(42, result); 
    }
	
	@Test
    public void testDivide() {
        // Arrange
		int a = 12;
        int b = 4;
        
        // Act
        int result = calc.divide(a, b);
        
        //Assert
        assertEquals(3, result); 
    }
	
	@Test
    public void testModulo() {
        // Arrange
		int a = 13;
        int b = 5;
        
        // Act
        int result = calc.modulo(a, b);
        
        //Assert
        assertEquals(3, result); 
    }
	
	@Test
    public void testFactorial() {
        // Arrange
		int a = 7;
        
        // Act
        int result = calc.factorial(a);
        
        //Assert
        assertEquals(5040, result); 
    }
}