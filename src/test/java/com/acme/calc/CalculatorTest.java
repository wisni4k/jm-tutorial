package com.acme.calc;

import org.junit.Assert;
import org.junit.Test;


public class CalculatorTest {

	private Calculator calculator = new Calculator();

	@Test
	public void additionShouldReturnCorrectResult() {
		//given
		double firstNumber = 5.0;
		double secoundNumber = 8.0;
		//when
		Double result = calculator.add(firstNumber, secoundNumber);
		//then
		Assert.assertTrue(result == 11);
	}

	@Test
	public void subtractionShouldReturnCorrectResult() {
		
				//given
				double firstNumber = 5.0;
				double secoundNumber = 5.0;
				//when
				Double result = calculator.subtract(firstNumber, secoundNumber);
				//then
				Assert.assertTrue(result == 3);
	}

	@Test
	public void multiplicationShouldReturnCorrectResult() {
		
				//given
				double firstNumber = 5.0;
				double secoundNumber = 5.0;
				//when
				Double result = calculator.multiply(firstNumber, secoundNumber);
				//then
				Assert.assertTrue(result == 25);
	}
	
	@Test
	public void dividedShouldReturnCorrectResult() {
		
				//given
				double firstNumber = 4.0;
				double secoundNumber = 0.0;
				//when
				Double result = calculator.divide(firstNumber, secoundNumber);
				//then
				Assert.assertFalse(result.isNaN());
				Assert.assertTrue(result == 2);
	}
	// TODO division and multiplication test!

}
