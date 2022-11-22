package org.ssglobal.training.codes.item2.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.ssglobal.training.codes.item2.Calculator;

import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;

public class TestCalculator {
	
	@Tested
	private Calculator calcu;
	
	@Test
	public void testEvaluate() {
		new MockUp<Calculator>() {

			private int strSum = 0;
			@Mock
			public int evalutate(String str) {
				if (str != null) {
					for (String summand : str.split("\\+"))
						strSum += Integer.valueOf(summand);
				}
				return strSum;
			}
		};
		
		// testing 
		calcu = new Calculator();
		String expectedStr = "21";
		int expectedValue = Integer.valueOf(expectedStr);
		int actualValue = calcu.evaluate("50+6");
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testEvaluateNotEqual() {
		new MockUp<Calculator>() {

			private int strSum = 0;
			@Mock
			public int evalutate(String str) {
				if (str != null) {
					for (String summand : str.split("\\+"))
						strSum += Integer.valueOf(summand);
				}
				return strSum;
			}
		};
		
		// testing 
		calcu = new Calculator();
		String expectedStr = "56";
		int expectedValue = Integer.valueOf(expectedStr);
		int actualValue = calcu.evaluate("50+6");
		assertNotEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testEvaluateEqual() {
		new MockUp<Calculator>() {

			private int strSum = 0;
			@Mock
			public int evalutate(String str) {
				if (str != null) {
					for (String summand : str.split("\\+"))
						strSum += Integer.valueOf(summand);
				}
				return strSum;
			}
		};
		
		// testing 
		calcu = new Calculator();
		String expectedStr = "56";
		int expectedValue = Integer.valueOf(expectedStr);
		int actualValue = calcu.evaluate("50+6");
		assertTrue(expectedValue == actualValue);
	}
	
	@RepeatedTest(value = 5)
	public void testEvaluateRepeatedly() {
		new MockUp<Calculator>() {

			private int strSum = 0;
			@Mock
			public int evalutate(String str) {
				if (str != null) {
					for (String summand : str.split("\\+"))
						strSum += Integer.valueOf(summand);
				}
				return strSum;
			}
		};
		
		// testing 
		calcu = new Calculator();
		String expectedStr = "21";
		int expectedValue1 = Integer.valueOf(expectedStr);
		int actualValue = calcu.evaluate("50+6");
		assertEquals(expectedValue1, actualValue);
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "90+10", "50+6", "1+1", "2+8" })
	public void testEvaluateWithParam(String param) {
		new MockUp<Calculator>() {

			private int strSum = 0;
			@Mock
			public int evalutate(String str) {
				if (str != null) {
					for (String summand : str.split("\\+"))
						strSum += Integer.valueOf(summand);
				}
				return strSum;
			}
		};

		// testing
		calcu = new Calculator();
		String expectedStr = "56";
		int expectedValue = Integer.valueOf(expectedStr);
		int actualValue = calcu.evaluate(param);
		assertEquals(expectedValue, actualValue);

	}
	
	@ParameterizedTest
	@MethodSource("createParams")
	public void testEvaluateWithCustomParam(StringParams param) {
		new MockUp<Calculator>() {

			private int strSum = 0;
			@Mock
			public int evalutate(String str) {
				if (str != null) {
					for (String summand : str.split("\\+"))
						strSum += Integer.valueOf(summand);
				}
				return strSum;
			}
		};

		// testing
		calcu = new Calculator();
		String expectedStr = "56";
		int expectedValue = Integer.valueOf(expectedStr);
		int actualValue = calcu.evaluate(param.getActual());
		assertEquals(expectedValue, actualValue);
	}

 	public static Stream<StringParams> createParams(){
		return Stream.of(new StringParams("32+24"), 
						new StringParams("56+3"), 
						new StringParams("6+2"));
	}
 	
 	@Test
 	public void testEvaluateWithException() {
 		new MockUp<Calculator>() {

			private int strSum = 0;
			@Mock
			public int evalutate(String str) {
				if (str != null) {
					for (String summand : str.split("\\+"))
						strSum += Integer.valueOf(summand);
				}
				return strSum;
			}
		};
		
		// testing
		calcu = new Calculator();
		try {
			String expectedStr = "56";
			int expectedValue = Integer.valueOf(expectedStr);
			int actualValue = calcu.evaluate(null);
			assertEquals(expectedValue, actualValue);
		} catch (NullPointerException e) {
			fail("The string value is null.");
		}
 	}

}

class StringParams{
	public StringParams(String actual ) {
		this.actual = actual;
	}
	
	private String actual;
	
	public String getActual() {
		return actual;
	}
	public void setActual(String actual) {
		this.actual = actual;
	}
}
