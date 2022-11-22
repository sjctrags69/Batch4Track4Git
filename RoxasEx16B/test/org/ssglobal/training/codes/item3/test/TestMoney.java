package org.ssglobal.training.codes.item3.test;

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
public class TestMoney {
	
	@Mock
	private Money money;
	
	@InjectMocks
	private CurrencyAnalytics ca;
	
	@Mock
	private CurrencyDb cdb;
	
	@Test
	public void testGetCurrency() {
		
		// stubbing (Given)
		money = new Money("peso", 5_000.00);	
		
		// execution (when)
		String expectNames = "peso";
		String actualNames = money.getCurrency();
		
		// assertion (Then)
		assertNotEquals(expectNames, actualNames);
	}
	
	@Test
	public void testTotalAmount() {
		
		// stubbing (Given)
		money = new Money("peso", 5_000.00);	
		List<Money> moneyIn = Arrays.asList(money);
		given(cdb.getMoney()).willReturn(moneyIn);
		
		// execution (when)
		double expectNames = 5000.00;
		double actualNames = ca.getTotalAmount();
		
		// assertion (Then)
		assertNotEquals(expectNames, actualNames);
	}
	
	

}
