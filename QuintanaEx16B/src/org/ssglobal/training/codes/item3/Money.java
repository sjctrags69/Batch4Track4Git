package org.ssglobal.training.codes.item3;

public class Money {
	private String currency;
	private Double amount;

	public Money(String currency, Double amount) {
		this.currency = currency;
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
// getters and setters
}
