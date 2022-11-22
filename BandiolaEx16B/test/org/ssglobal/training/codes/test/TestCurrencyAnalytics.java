package org.ssglobal.training.codes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.BDDMockito.given;
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
	private CurrencyDb repo;

	@InjectMocks
	private CurrencyAnalytics service;

	@Test
	public void testGetAllCurrency() {
		List<Money> list = new ArrayList<>();
		list.add(new Money("USD", 1.0));
		list.add(new Money("PHP", 50.0));
		list.add(new Money("JPY", 100.0));
		list.add(new Money("EUR", 1.5));

		given(repo.getMoney()).willReturn(list);

		List<String> expected = Arrays.asList("USD", "PHP", "JPY", "EUR");
		List<String> actual = service.getAllCurrency();

		assertIterableEquals(expected, actual);
		System.out.println("testGetAllCurrency() passed");
	}

	@Test
	public void getTotalAmount(){
		List<Money> list = new ArrayList<>();
		list.add(new Money("USD", 1.0));
		list.add(new Money("PHP", 50.0));
		list.add(new Money("JPY", 100.0));
		list.add(new Money("EUR", 1.5));

		given(repo.getMoney()).willReturn(list);

		double expected = 152.5;
		double actual = service.getTotalAmount();

		assertEquals(expected, actual);
		System.out.println("testGetTotalAmount() passed");
	}
}
