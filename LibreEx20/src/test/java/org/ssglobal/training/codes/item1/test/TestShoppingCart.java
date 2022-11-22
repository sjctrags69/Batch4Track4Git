package org.ssglobal.training.codes.item1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.item1.Product;
import org.ssglobal.training.codes.item1.ProductNotFoundException;
import org.ssglobal.training.codes.item1.ShoppingCart;

import mockit.Tested;

public class TestShoppingCart {
	
	@Tested
	private ShoppingCart cart;
	
	
	@Test
	public void testCreateCart() {
		int expectCart = 0;
		int actualCart = cart.getItemCount();
		assertEquals(expectCart, actualCart);
	}
	
	@Test
	public void testEmptyCart() {
		int expectCart = 0;
		cart.empty();
		assertEquals(expectCart, cart.getItemCount());
	}
	
	@Test
	public void testAddProduct() {
		int expectCart = 1;
		cart.addItem(new Product("Pants", 1000.00));
		assertEquals(expectCart, cart.getItemCount());
	}
	
	@Test
	public void testAddProductNewBalance() {
		double expectBalance = 1500.00;
		cart.addItem(new Product("Pants", 1000.00));
		cart.addItem(new Product("Shirt", 500.00));
		assertTrue(cart.getBalance() == expectBalance);
	}
	
	@Test
	public void testDeleteProduct() throws ProductNotFoundException {
			cart.addItem(new Product("Pants", 1000.00));
			cart.addItem(new Product("Shirt", 500.00));
			cart.removeItem(new Product("Pants", 1000.00));
			int expectItemCount = 1;
			int actualItemCount = cart.getItemCount();
			assertEquals(expectItemCount, actualItemCount);
	}
	
	@Test
	public void testDeleteproductDoesNotExist() {
		assertThrows(ProductNotFoundException.class, () -> {
			cart.addItem(new Product("Pants", 1000.00));
			cart.removeItem(new Product("Skirt", 1000.00));
		});
	}
}
