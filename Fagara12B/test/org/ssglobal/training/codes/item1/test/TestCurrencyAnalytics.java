package org.ssglobal.training.codes.item1.test;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.ssglobal.training.codes.item1.CurrencyAnalytics;
import org.ssglobal.training.codes.item1.CurrencyDb;
import org.ssglobal.training.codes.item1.Money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.BDDMockito.given;

public class TestCurrencyAnalytics {
	
	@Mock
	private CurrencyDb repo;
	
	@InjectMocks
	private CurrencyAnalytics analysis;

	
	@Test
	public void testGetCurrency() {
		// stubbing
		Money money1 = new Money("Peso", 1.00);
		Money money2 = new Money("Dollar", 57.50);
		List<Money> moneyTbl =  Arrays.asList(money1, money2);
		given(repo.getMoney()).willReturn(moneyTbl);
		
		// testing
		List<String> expectedMoney = Arrays.asList("Peso", "Dollar");
		List<String> actualMoney = analysis.getAllCurrency();
		
		// assert
		assertIterableEquals(expectedMoney, actualMoney);
		System.out.println(actualMoney);
		
	}
	
	@Test
	public void testGetTotalAmount() {
		// stubbing
		Money money1 = new Money("Peso", 1.00);
		Money money2 = new Money("Dollar", 57.50);
		List<Money> moneyTbl =  Arrays.asList(money1, money2);
		given(repo.getMoney()).willReturn(moneyTbl);
		
		double expectedAmount = 50.00;
		double actualAmount = analysis.getTotalAmount();
		
		assertEquals(expectedAmount, actualAmount);
	}
	
	

}
