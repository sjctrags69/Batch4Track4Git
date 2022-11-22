package org.ssglobal.training.codes.item2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.ssglobal.training.codes.item2.Calculator;

import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;

public class TestCalculator {

	@Tested
	private Calculator calc;
	
	@Test
	public void testEvaluate1() {
		new MockUp<Calculator>() {
			
			@Mock
			public int evaluate(String str) {
				int sum = 0;
				for (String summand: str.split("\\+"))
					sum += Integer.valueOf(summand);
				return sum;
			}
		};
		
		int expectValue = 2;
		int actualValue = calc.evaluate("1+1");
		assertEquals(expectValue, actualValue);
	}
	
	@Test
	public void testEvaluate2() {
		new MockUp<Calculator>() {
			
			@Mock
			public int evaluate(String str) {
				int sum = 0;
				for (String summand: str.split("\\+"))
					sum += Integer.valueOf(summand);
				return sum;
			}
		};
		
		int expectValue = 2;
		int actualValue = calc.evaluate("1+1");
		assertNotEquals(expectValue, actualValue);

	}
	
	@Test
	public void testEvaluate3() {
		new MockUp<Calculator>() {
			
			@Mock
			public int evaluate(String str) {
				int sum = 0;
				for (String summand: str.split("\\+"))
					sum += Integer.valueOf(summand);
				return sum;
			}
		};
		
		int expectValue = 2;
		int actualValue = calc.evaluate("1+1");
		assertTrue(expectValue == actualValue);
	}
	
	@RepeatedTest(value = 3)
	public void testEvaluate4() {
		new MockUp<Calculator>() {
			
			@Mock
			public int evaluate(String str) {
				int sum = 0;
				for (String summand: str.split("\\+"))
					sum += Integer.valueOf(summand);
				return sum;
			}
		};
		
		int expectValue = 2;
		int actualValue = calc.evaluate("1+1");
		assertTrue(expectValue == actualValue);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"2+3", "3+2" , "5+0"})
	public void testEvaluate5(String num) {
		new MockUp<Calculator>() {
			
			@Mock
			public int evaluate(String str) {
				int sum = 0;
				for (String summand: str.split("\\+"))
					sum += Integer.valueOf(summand);
				return sum;
			}
		};
		
		int expectValue = 5;
		int actualValue = calc.evaluate(num);
		assertTrue(expectValue == actualValue);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"5+5", "6+4" , "7+3"})
	public void testEvaluate6(String num) {
		new MockUp<Calculator>() {
			
			@Mock
			public int evaluate(String str) {
				int sum = 0;
				for (String summand: str.split("\\+"))
					sum += Integer.valueOf(summand);
				return sum;
			}
		};
		
		int expectValue = 10;
		int actualValue = calc.evaluate(num);
		assertEquals(expectValue,actualValue);
	}
	
	@Test
	public void testEvaluate7() {
		new MockUp<Calculator>() {
			
			@Mock
			public int evaluate(String str) throws NullPointerException, Exception {
				int sum = 0;
				if (str != null) {
					for (String summand: str.split("\\+"))
					sum += Integer.valueOf(summand);
					return sum;
				}
				throw new NullPointerException();
			}
		};
		
		assertDoesNotThrow(() -> {
			int expectValue = 2;
			int actualValue = calc.evaluate(null);
			assertEquals(expectValue,actualValue);
		});
		
	}
	

}
