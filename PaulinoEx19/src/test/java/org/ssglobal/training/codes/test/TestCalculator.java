package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.ssglobal.training.codes.Calculator;

import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;

public class TestCalculator {

	@Tested
	private Calculator calc;
	
	@Test
	public void testEvaluateSringWithoutSpacesSunnyDay() {
		int expectedResult = 8;
		int actualResult = calc.evaluate("4+2+2");
		assertEquals(expectedResult, actualResult);
	}
		
	@Test
	public void testEvaluateStringWithOneNegativeSignSunnyDay() {
		int expectedResult = -8;
		int actualResult = calc.evaluate("-11+3");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testEvaluateStringWithTwoNegativeSignSunnyDay() {
		int equalsZero = -8;
		int actualResult = calc.evaluate("-4+-4");
		assertTrue(actualResult == equalsZero);
	}	
	
	@RepeatedTest(5)
	public void testEvaluateRepeatedTestingSunnyDay() {
		int expectedResult = 77;
		int actualResult = calc.evaluate("70+7");
		assertEquals(expectedResult, actualResult);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"1+1", "2+2", "3+3", "4+4", "5+5", "6+6"})
	public void testEvaluateParameterizedTestWithPositiveNumbersSunnyDay(String param) {
		int expectedResult = 20;
		int actualResult = calc.evaluate(param);
		assertTrue(expectedResult > actualResult);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"-1+3", "2+2", "-3+-3", "-4+4", "5+-5", "6+-6"})
	public void testEvaluateParameterizedTestWithNegativeNumbersSunnyDay(String param) {
		int expectedResult = 8;
		int actualResult = calc.evaluate(param);
		assertTrue(expectedResult > actualResult);
	}
	
	@Test
	public void testEvaluateWithExceptionTestingSunnyDay() {
		new MockUp<Calculator>() {
			
			//proposed solution for the method evaluate(String expression) of Calculator class
			@Mock
			public int evaluate(String expression) throws NumberFormatException, Exception{
				int sum = 0;
				if(expression.contains(" ") || expression.contains(".")) {
					throw new NumberFormatException();
				} else {
					for (String summand : expression.split("\\+"))
						sum += Integer.valueOf(summand);
					return sum;
				}
			}
		};
		
		int expectedResult = 77;
		assertDoesNotThrow(() -> {
			int actualResult = calc.evaluate("70.0+ 7");
			assertEquals(expectedResult, actualResult);
		});

	}
}

