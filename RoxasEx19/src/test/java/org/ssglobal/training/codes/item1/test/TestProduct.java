package org.ssglobal.training.codes.item1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.item1.Product;
import org.ssglobal.training.codes.item1.ProductNotFoundException;
import org.ssglobal.training.codes.item1.ShoppingCart;

import mockit.Expectations;
import mockit.Tested;

public class TestProduct {

	
	private Product prod;
	
	@Tested
	private ShoppingCart sc;
	
	@Test
	public void testCreateCart() {
		
		// mocking
		new Expectations() {
			{
				prod = new Product(null, 0.0);
				sc.addItem(prod);
			}
		};
		
		//testing
		int expectedValue = 0;
		int actualValue = sc.getItemCount();
		System.out.println(actualValue);
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testEmptyCart() {
		
		// mocking
		new Expectations() {
			{
				prod = new Product("", 0.0);
				sc.addItem(prod);
			}
		};
		
		//testing
		int expectedValue = 0;
		int actualValue = sc.getItemCount();
		System.out.println(actualValue);
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testAddProduct() {
		
		// mocking
		new Expectations() {
			{
				Product prod = new Product("shampoo", 20.5);
				sc.addItem(prod);
			}
		};
		
		//testing
		int expectedValue = 1;
		int actualValue = sc.getItemCount();
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testAddProductNewBalance() {
		
		// mocking
		new Expectations() {
			{
				Product prod = new Product("shampoo", 20.5);
				sc.addItem(prod);
			}
		};
		
		//testing
		double expectedValue = 20.5;
		double actualValue = sc.getBalance();
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testDeleteProduct() throws ProductNotFoundException {
		
		// mocking
		new Expectations() {
			{
				Product prod1 = new Product("shampoo", 20.5);
				Product prod2 = new Product("shampoo", 20.5);
				sc.addItem(prod1);
				sc.addItem(prod2);
				sc.removeItem(prod1);
			}
		};
		
		//testing

		assertDoesNotThrow(() -> {
			int expectedValue = 1;
			int actualValue = sc.getItemCount();
			assertEquals(expectedValue, actualValue);
		});
		
	}
	
	@Test
	public void testDeleteproductDoesNotExists() throws ProductNotFoundException, Exception {
		
		// mocking
		new Expectations() {
			{
				Product prod1 = new Product("shampoo", 20.5);
				Product prod2 = new Product("shampoo", 20.5);
				sc.addItem(prod1);
				sc.removeItem(prod2);
			}
		};
		
		//testing

		assertDoesNotThrow(() -> {
			int expectedValue = 1;
			int actualValue = sc.getItemCount();
			assertEquals(expectedValue, actualValue);
		}, "Product not found");
		
	}
	
	
	
	
	
}
