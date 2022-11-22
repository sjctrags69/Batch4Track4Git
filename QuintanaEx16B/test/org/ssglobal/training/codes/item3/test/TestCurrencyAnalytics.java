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
import org.ssglobal.training.codes.item3.CurrencyDB;
import org.ssglobal.training.codes.item3.Money;

@ExtendWith(MockitoExtension.class)
public class TestCurrencyAnalytics {

	@Mock
	private CurrencyDB repo;

	@InjectMocks
	private CurrencyAnalytics analytics;

	@Test
	public void testGetAllCurrency() {

		// stubbing (Given)
		Money m1 = new Money("PHP", 1000.0);
		Money m2 = new Money("USD", 5000.0);
		Money m3 = new Money("JPY", 500.0);
		List<Money> moneyList = Arrays.asList(m1, m2, m3);
		given(repo.getMoney()).willReturn(moneyList);

		// execution (when)
		List<String> expectNames = Arrays.asList("PHP", "USD", "JPY");
		List<String> actualNames = analytics.getAllCurrency();

		// assert (then)
		assertIterableEquals(expectNames, actualNames);
	}

	@Test
	public void testGetTotalAmount() {

		// stubbing (Given)
		Money m1 = new Money("PHP", 1000.0);
		Money m2 = new Money("USD", 5000.0);
		Money m3 = new Money("JPY", 500.0);
		List<Money> moneyList = Arrays.asList(m1, m2, m3);
		given(repo.getMoney()).willReturn(moneyList);

		// execution (when)
		Double expectTotal = 6500.00;
		Double actualTotal = analytics.getTotalAmount();

		// assert (then)
		assertNotEquals(expectTotal, actualTotal);
	}
}
