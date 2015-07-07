package com.acme.calc;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calculator = new Calculator();

	@Test
	public void additionShouldReturnCorrectResult() {
		// given
		double firstNumber = 5.0;
<<<<<<< HEAD
		double secoundNumber = 5.0;
		// when
		Double result = calculator.add(firstNumber, secoundNumber);
		// then
		Assert.assertTrue(result == 10);
=======
		double secondNumber = 6.0;
		// when
		Double result = calculator.add(firstNumber, secondNumber);
		// then
		Assert.assertFalse(result.isNaN());
		Assert.assertTrue(result == 11);
>>>>>>> upstream/master
	}

	private double firstNumber;
	private double secondNumber;
	private Exception thrown;
	@Test
<<<<<<< HEAD
	public void subtractionShouldReturnCorrectResult() {

		// given
		double firstNumber = 5.0;
		double secoundNumber = 5.0;
		// when
		Double result = calculator.subtract(firstNumber, secoundNumber);
		// then
		Assert.assertTrue(result == 0);
	}

	@Test
	public void multiplicationShouldReturnCorrectResult() {

		// given
		double firstNumber = 5.0;
		double secoundNumber = 5.0;
		// when
		Double result = calculator.multiply(firstNumber, secoundNumber);
		// then
		Assert.assertTrue(result == 25);
=======
	public void divisionShouldThrowExceptionWhenDivisorIsZero() {
		givenNumbersWithZero();
		catchException(() -> calculator.divide(firstNumber,secondNumber));
		assertException(DivisorCannotBeZeroException.class);
	}

	private void catchException(Runnable runnable) {
		try {
			runnable.run();
		} catch (Exception e) {
			thrown = e;
		}
	}

	private void assertException(Class<DivisorCannotBeZeroException> expectedExceptionClass) {
		Assert.assertNotNull(thrown);
		Assert.assertTrue(expectedExceptionClass.equals(thrown.getClass()));
	}
	private void assertThat(Exception e, Class<?> expectedClass) {
		Assert.assertTrue(e.getClass().equals(expectedClass));
	}
	private void thenCorrectExceptionIsThrons(Exception e) {
		Assert.assertTrue(e.getClass().equals(
				DivisorCannotBeZeroException.class));
	}
	// TODO division and multiplication test!
	private void givenNumbersWithZero() {
		firstNumber = 5.0;
		secondNumber = 0.0;
>>>>>>> upstream/master
	}

	@Test
	public void dividedShouldReturnCorrectResult() {

		// given
		double firstNumber = 4.0;
		double secoundNumber = 2.0;
		// when
		Double result = calculator.divide(firstNumber, secoundNumber);
		// then
		Assert.assertFalse(result.isNaN());
		Assert.assertTrue(result == 2);
	}

	@Test(expected = DivisorCannotBeZeroException.class)
	public void dividedShouldReturnCorrectResultWhenDivisiorIsZero() {

		// given
		double firstNumber = 4.0;
		double secoundNumber = 0.0;
		// when
		Double result = calculator.divide(firstNumber, secoundNumber);
	}
}
