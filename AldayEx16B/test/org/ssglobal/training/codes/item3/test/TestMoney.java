package org.ssglobal.training.codes.item3.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.ssglobal.training.codes.item3.CurrencyAnalytics;
import org.ssglobal.training.codes.item3.CurrencyDb;
import org.ssglobal.training.codes.item3.Money;

public class TestMoney {

	@Mock
	private CurrencyDb cdb;

	@InjectMocks
	private CurrencyAnalytics ca;

	@Mock
	private Money mon;

	@Test
	public void testGetCurrency() {
		mon = new Money("Won", 600.0);

		String expect = "Won";
		String actual = mon.getCurrency();

		assertNotEquals(expect, actual);
	}

	@Test
	public void getTotalAmount() {
		mon = new Money("Won", 600.0);

		double expect = 600;
		double actual = ca.getTotalAmount();
		assertNotEquals(expect, actual);
	}
}
