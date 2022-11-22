package org.ssglobal.training.codes.item1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
//import static org.junit.jupiter.api.Assertions.as;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ssglobal.training.codes.item1.CurrencyAnalytics;
import org.ssglobal.training.codes.item1.CurrencyDb;
import org.ssglobal.training.codes.item1.Money;

@ExtendWith(MockitoExtension.class)
public class TestCurrencyAnalytics {
	@Mock
	private CurrencyDb repo;
	
	@InjectMocks
	private CurrencyAnalytics curAnalytics;
	
	@Test
	public void testAllCurrency() {
//		stubbing 
		Money mon1 = new Money("USD", 50000.00);
		Money mon2 = new Money("PHP", 100000.00);
		Money mon3 = new Money("AUD", 60000.00);
		List<Money> moneyTbl = Arrays.asList(mon1, mon2, mon3);
		given(repo.getMoney()).willReturn(moneyTbl);

		System.out.println("-----------------\ngetAllCurrency() Test");
//		execution
		List<String> expectCurrencies = Arrays.asList("USD", "EUR", "AUD");
		System.out.println("Expected: %s".formatted(expectCurrencies));
		List<String> actualCurrencies = curAnalytics.getAllCurrency();
		System.out.println("Actual: %s".formatted(actualCurrencies));
//		assertion
		assertIterableEquals(expectCurrencies, actualCurrencies);
		
	}
	
	@Test
	public void testTotalAmount() {
//		stubbing 
		Money mon1 = new Money("USD", 50000.00);
		Money mon2 = new Money("PHP", 100000.00);
		Money mon3 = new Money("AUD", 60000.00);
		List<Money> moneyTbl = Arrays.asList(mon1, mon2, mon3);
		given(repo.getMoney()).willReturn(moneyTbl);

		System.out.println("-----------------\ngetTotalAmount() Test");
//		execution
		double expectTotalAmount = 120000.00;
		System.out.println("Expected: %.2f".formatted(expectTotalAmount));
		double actualTotalAmount = curAnalytics.getTotalAmount();
		System.out.println("Actual: %.2f".formatted(actualTotalAmount));
//		assertion
		assertEquals(expectTotalAmount, actualTotalAmount);
		
	}
	
}
