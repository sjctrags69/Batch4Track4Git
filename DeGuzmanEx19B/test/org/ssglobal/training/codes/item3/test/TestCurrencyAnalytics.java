package org.ssglobal.training.codes.item3.test;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ssglobal.training.codes.item3.CurrencyAnalytics;
import org.ssglobal.training.codes.item3.CurrencyDb;
import org.ssglobal.training.codes.item3.Money;

@ExtendWith(MockitoExtension.class)
public class TestCurrencyAnalytics {

	@Mock
	private CurrencyDb currencyDB;
	
	@InjectMocks
	private CurrencyAnalytics currAnalytics;
	
	@Test
	public void testGetAllCurrency() throws NullPointerException, Exception{
		Money pesos = new Money("Pesos", 57.5);
		Money dollars = new Money("Dollars", 100.00);
		List<Money> currencies = Arrays.asList(pesos, dollars);
		given(currencyDB.getMoney()).willReturn(currencies);
		
		// execution (when)
		List<String> expectNames = Arrays.asList("Dollars", "Dollars");
		List<String> actualNames = currAnalytics.getAllCurrency();
		System.out.println(actualNames);
		// assertion (Then)
		assertIterableEquals(expectNames, actualNames);
	}
	
	@Test
	public void testGetTotalAmount()throws NullPointerException, Exception{
		Money pesos = new Money("Pesos", 57.5);
		Money dollars = new Money("Pesos", 100.00);
		List<Money> currencies = Arrays.asList(pesos, dollars);
		given(currencyDB.getMoney()).willReturn(currencies);
		
		// execution (when)
		double totalExpected = 157.5;
		double totalActual = currAnalytics.getTotalAmount();
		System.out.println(totalActual);
				
		// assertion (Then)
		assertNotEquals(totalExpected, totalActual);
	}
}
