package org.ssglobal.training.codes.item3.test;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
	private CurrencyDb db;
	
	@InjectMocks
	private CurrencyAnalytics analytics;
	
	@Test
	public void testGetAllCurrencyRainy() {
		// stubbing
		Money m1 = new Money("PHP", 500.00);
		Money m2 = new Money("USD", 20.00);
		Money m3 = new Money("JPY", 4000.00);
		List<Money> moneyList = Arrays.asList(m1, m2, m3);
		given(db.getMoney()).willReturn(moneyList);
		
		// execution
		List<String> expected = Arrays.asList("PHP", "USD");
		List<String> actual = analytics.getAllCurrency();
		
		// then
		assertIterableEquals(expected, actual);
	}
	
	@Test
	public void testGetTotalAmountRainy() {
		// stubbing
		Money m1 = new Money("PHP", 500.00);
		Money m2 = new Money("USD", 20.00);
		Money m3 = new Money("JPY", 4000.00);
		List<Money> moneyList = Arrays.asList(m1, m2, m3);
		given(db.getMoney()).willReturn(moneyList);
		
		// execution
		double expectedVal = 4520.00;
		double actualVal = analytics.getTotalAmount();
		
		// then
		assertNotEquals(expectedVal, actualVal);
	}

}
