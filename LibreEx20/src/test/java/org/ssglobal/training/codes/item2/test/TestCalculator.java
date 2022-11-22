package org.ssglobal.training.codes.item2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.ssglobal.training.codes.item2.Calculator;

import mockit.Tested;

public class TestCalculator {

	@Tested
	private Calculator cal;
	
	@Test
	public void testEvaluateEquals() {
		int expectedResult = 20;
		int actualResult = cal.evaluate("10+10");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testEvaluateNotEquals() {
		int expectedResult = 20;
		int actualResult = cal.evaluate("5+5");
		assertNotEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testEvaluateTrue() {
		int actualSum = 40;
		int expectedSum = cal.evaluate("15+15");
		assertTrue(actualSum >= expectedSum);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"15+15"})
	public void testEvaluateFalse(String param) {
		int actualSum = cal.evaluate("20+20");
		int expectedSum = cal.evaluate(param);
		assertFalse(actualSum <= expectedSum);
	}
	
	@RepeatedTest(3)
	public void testEvaluateRepeatedEquals() {
		int expectedResult = 20;
		int actualResult = cal.evaluate("10+10");
		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	public void testEvaluateExceptionNull() {
		int expectedResult = 20;
		assertThrows(IllegalArgumentException.class, () -> {
			int actualResult = cal.evaluate(null);
			assertEquals(expectedResult, actualResult);
		}, "value must not be null.");
		
	}
}

