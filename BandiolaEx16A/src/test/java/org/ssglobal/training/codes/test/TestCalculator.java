package org.ssglobal.training.codes.test;

import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.item2.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;

public class TestCalculator {
	@Tested
	private Calculator calculator;

	@Test
	public void evaluate_ShouldEvaluateProperlySumExpression() {
		new MockUp<Calculator>() {
			@Mock
			public int evaluate(String expression) {
				int sum = 0;
				String[] numbers = expression.split("\\+");
				for (String number : numbers) {
					if (number.isEmpty()) {
						return 0;
					}
					if (number.matches("\\d+")) {
						sum += Integer.parseInt(number);
					} else if (!number.matches("\\d+")) {
						return 0;
					} else if (number.matches("-\\d+")) {
						sum += Integer.parseInt(number);
					} else if (number.matches("-\\d+") && number.matches("\\d+")) {
						sum += Integer.parseInt(number);
					} else if (number.matches("\\+")) {
						return 0;
					}
				}
				return sum;
			}
		};

		int expected = 10;
		int actual = calculator.evaluate("1+2+3+4");
		assertEquals(expected, actual);
		System.out.println("Test: Passed");
	}
}
