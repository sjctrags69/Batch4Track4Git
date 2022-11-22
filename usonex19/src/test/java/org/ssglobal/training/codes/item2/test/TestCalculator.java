package org.ssglobal.training.codes.item2.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.item2.Calculator;

import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;
import mockit.Verifications;

public class TestCalculator {
	@Tested
	Calculator calc;
	
	@Test
	public void testEvaluateException() {
			
			
			new MockUp<Calculator>(){
				// Proposed solution
				@Mock
				public int evaluate(String exp) {
					int sum = 0;
					  
					for (int i = 0; i < exp.length(); i++) {
						String ch = String.valueOf(exp.charAt(i));
						sum += Integer.valueOf(ch);		
				 	}
				return sum;
				}
				
			};
			assertDoesNotThrow(() -> {
				int expectedValue = 0;
				int actualValue = calc.evaluate("asdfgaf");
				assertEquals(expectedValue, actualValue);
			}, "exception");
	}
	
	@Test
	public void testEvaluateAssertComparator1() {
		
		
		new MockUp<Calculator>(){
			// Proposed solution
			@Mock
			public int evaluate(String exp) {
				int sum = 0;
				  
				for (int i = 0; i < exp.length(); i++) {
					String ch = String.valueOf(exp.charAt(i));
					sum += Integer.valueOf(ch);		
			 	}
			return sum;
			}
			
		};
		int expectedValue = 6;
		int actualValue = calc.evaluate("123");
		assertEquals(expectedValue, actualValue);
	}
	

	@Test
	public void testEvaluateAssertComparator2() {
		
		int expectedValue = 6;
		int actualValue = calc.evaluate("123");
		assertEquals(expectedValue, actualValue);
		
	}
	
	@Test
	public void testEvaluateAssertComparator3() {
			
			
			new MockUp<Calculator>(){
				// Proposed solution
				@Mock
				public int evaluate(String exp) {
					int sum = 0;
					  
					for (int i = 0; i < exp.length(); i++) {
						String ch = String.valueOf(exp.charAt(i));
						sum += Integer.valueOf(ch);		
				 	}
				return sum;
				}
				
			};
			int expectedValue = 0;
			int actualValue = calc.evaluate("00000000");
			assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testEvaluateRepeated() {
		
	
		new MockUp<Calculator>(){
			// Proposed solution
			@Mock
			public int evaluate(String exp) {
				int sum = 0;
				  
				for (int i = 0; i < exp.length(); i++) {
					String ch = String.valueOf(exp.charAt(i));
					sum += Integer.valueOf(ch);		
			 	}
			return sum;
			}
			
		};

		new Verifications() {
			{
				int expectedValue = 0;
				int actualValue = calc.evaluate("00000000");
				assertEquals(expectedValue, actualValue);
				times = 3;
			}
		};
		
		
	}
	
	
	
	
}
