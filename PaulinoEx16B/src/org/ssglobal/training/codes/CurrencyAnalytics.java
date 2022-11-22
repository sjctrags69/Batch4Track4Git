package org.ssglobal.training.codes;

import java.util.ArrayList;
import java.util.List;

public class CurrencyAnalytics {
	private CurrencyDb db = new CurrencyDb();

	public List<String> getAllCurrency(){
		List<Money> moonies = db.getMoney();
		List<String> currencies = new ArrayList<>();
			for(Money lookup: moonies){
				currencies.add(lookup.getCurrency());
			}
			return currencies;
	}

	public double getTotalAmount() {
		List<Money> moonies = db.getMoney();
		double total = 0.0;
		for (Money lookup : moonies) {
			total += lookup.getAmount();
		}
		return total;
	}
}
