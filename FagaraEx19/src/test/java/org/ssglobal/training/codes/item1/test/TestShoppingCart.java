package org.ssglobal.training.codes.item1.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.item1.Product;
import org.ssglobal.training.codes.item1.ProductNotFoundException;
import org.ssglobal.training.codes.item1.ShoppingCart;

import mockit.Expectations;
import mockit.Tested;
import mockit.Verifications;

public class TestShoppingCart {
 
	//private Product product;
	
	@Tested
	private ShoppingCart cart;
	
	@Test
	public void testCreateCart() {
		
		// mocking
		new Expectations() {
			{
				Product product = new Product(null, 0.0);
				cart.addItem(product);
				List<Product> itemCart = Arrays.asList(product);
				result = itemCart;
			}
		};
		
		//testing
		int expectedItemCount = 0;
		int actualItemCount = cart.getItemCount();
		assertEquals(expectedItemCount, actualItemCount);	
	}
	
	@Test
	public void testEmptyCart() throws ProductNotFoundException {
		
		// mocking
		new Expectations() {
			{
				Product product = new Product("Milk", 345.99);
				cart.addItem(product);
				cart.removeItem(product);
			}
		};
		
		// testing
		assertDoesNotThrow(() -> {
			int expectedItemCount = 0;
			int actualItemCount = cart.getItemCount();
			assertEquals(expectedItemCount, actualItemCount);
		});
	}
	
	@Test
	public void testAddProduct() {
		// mocking
		new Expectations() {
			{
				Product product = new Product("Soy Milk", 567.78);
				cart.addItem(product);
			}
		};
		
		// testing
		int expectedItemCount = 1;
		int actualItemCount = cart.getItemCount();
		assertEquals(expectedItemCount, actualItemCount);	
	}
	
	@Test
	public void testAddProductNewBalance() {
		// mocking
		new Expectations() {
			{
				Product p1 = new Product("Soy Milk", 567.78);
				Product p2 = new Product("Whitening Lotion", 599.99);
				cart.addItem(p1);
				cart.addItem(p2);
			}
		};
		
		// testing 
		double expectedBalance = 1167.77;
		double actualBalance = cart.getBalance();
		assertEquals(expectedBalance, actualBalance);	
	}
	
	@Test
	public void testDeleteProduct() throws ProductNotFoundException {
		// mocking
		new Expectations() {
			{
				Product p1 = new Product("Soy Milk", 567.78);
				Product p2 = new Product("Whitening Lotion", 599.99);
				cart.addItem(p1);
				cart.addItem(p2);
				cart.removeItem(p2);
			}
		};
		
		// testing
		assertDoesNotThrow(() -> {
			int expectedItemCount = 0;
			int actualItemCount = cart.getItemCount();
			assertEquals(expectedItemCount, actualItemCount);
		});
		
		// verification 
		new Verifications() {
			{
				cart.getItemCount();
				maxTimes = 2;
			}
		};
	}
	
	@Test
	public void testDeleteProductDoesNotExist() throws ProductNotFoundException {
		// mocking
		new Expectations() {
			{
				Product p1 = new Product("Soy Milk", 567.78);
				Product p2 = new Product("Whitening Lotion", 599.99);
				cart.addItem(p1);
				cart.removeItem(p2);
			}
		};
		
		// testing
		int expectedItemCount = 2;
		int actualItemCount = cart.getItemCount();
		assertEquals(expectedItemCount, actualItemCount);
		
	}
}

	
