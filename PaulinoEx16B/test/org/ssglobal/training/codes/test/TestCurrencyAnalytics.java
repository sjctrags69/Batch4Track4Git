package org.ssglobal.training.codes.test;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ssglobal.training.codes.CurrencyAnalytics;
import org.ssglobal.training.codes.CurrencyDb;
import org.ssglobal.training.codes.Money;

@ExtendWith(MockitoExtension.class)
public class TestCurrencyAnalytics {
	
	@Mock
	private CurrencyDb repo;
	
	@InjectMocks
	private CurrencyAnalytics analysis;
	
	@Test
	public void testGetCurrencyRainyDay() {
		
		//stubbing
		Money currency1 = new Money("peso", 1.0);
		Money currency2 = new Money("dollar", 50.0);
		Money currency3 = new Money("euro", 60.0);
		List<Money> currRec = Arrays.asList(currency1, currency2, currency3);
		given(repo.getMoney()).willReturn(currRec);
		
		//execution
		List<String> expectedCurrencies = Arrays.asList("peso", "dollar", "euro");
		List<String> actualCurrencies = analysis.getAllCurrency();
		
		//assertion
		assertNotEquals(expectedCurrencies, actualCurrencies);
	}
	
	@Test
	public void testGetTotalAmountRainyDay() {
		
		//stubbing
		Money currency1 = new Money("peso", 1.0);
		Money currency2 = new Money("dollar", 50.0);
		Money currency3 = new Money("euro", 60.0);
		List<Money> currRec = Arrays.asList(currency1, currency2, currency3);
		given(repo.getMoney()).willReturn(currRec);
		
		//execution
		double expectedTotal = 111.0;
		double actualTotal = analysis.getTotalAmount();
		
		//assertion
		assertNotEquals(expectedTotal, actualTotal);
	}
}
