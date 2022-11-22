package org.ssglobal.training.codes.test;

import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.item1.Product;
import org.ssglobal.training.codes.item1.ProductNotFoundException;
import org.ssglobal.training.codes.item1.ShoppingCart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import mockit.Tested;

public class TestShoppingCart {

	@Tested
	private ShoppingCart cart;

	@Test
	public void testCreateCart() {
		int expected = 0;
		int actual = cart.getItemCount();
		assertEquals(expected, actual);
		System.out.println("Create Cart: PASSED");
	}

	@Test
	public void testEmptyCart() {
		cart.empty();
		int expected = 0;
		int actual = cart.getItemCount();
		assertEquals(expected, actual);
		System.out.println("Empty Cart: PASSED");
	}

	@Test
	public void testAddProduct() {
		cart.addItem(new Product("P1", 100.00));
		int expected = 1;
		int actual = cart.getItemCount();
		assertEquals(expected, actual);
		System.out.println("Add Product: PASSED");
	}

	@Test
	public void testAddProductNewBalance() {
		cart.addItem(new Product("P1", 100.00));
		cart.addItem(new Product("P2", 200.00));

		double expected = 300.00;
		double actual = cart.getBalance();
		assertEquals(expected, actual);
		System.out.println("Add Product New Balance: PASSED");
	}

	@Test
	public void testDeleteProduct() {
		Product p1 = new Product("P1", 100.00);
		Product p2 = new Product("P2", 200.00);
		cart.addItem(p1);
		cart.addItem(p2);

		assertDoesNotThrow(() -> cart.removeItem(p1));

		int expected = 1;
		int actual = cart.getItemCount();
		assertEquals(expected, actual);
		System.out.println("Delete Existing Product: PASSED");
	}

	@Test
	public void testDeleteproductDoesNotExists() {
		Product p1 = new Product("P1", 100.00);
		Product p2 = new Product("P2", 200.00);
		cart.addItem(p1);

		assertThrows(ProductNotFoundException.class, () -> cart.removeItem(p2));

		int expected = 1;
		int actual = cart.getItemCount();
		assertEquals(expected, actual);
		System.out.println("Delete Non-Existing Product: PASSED");
	}
}
