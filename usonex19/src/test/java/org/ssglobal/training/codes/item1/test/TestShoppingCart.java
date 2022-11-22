package org.ssglobal.training.codes.item1.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.item1.Product;
import org.ssglobal.training.codes.item1.ShoppingCart;

import mockit.Tested;

public class TestShoppingCart {

	@Tested
	ShoppingCart cart;
	
	@Test
	public void testCreateCart() {
		int expectedVal = 0;
		int actualValue = cart.getItemCount();
		assertEquals(expectedVal, actualValue);
	}
	
	@Test
	public void testEmptyCart() {
		cart.empty();
		int expectedVal = 0;
		int actualValue = cart.getItemCount();
		assertEquals(expectedVal, actualValue);
	}
	
	@Test
	public void testAddProduct() {
		int itemCountBeforeAdd = cart.getItemCount();
		Product p1 = new Product("Tuna", 40.00);
		cart.addItem(p1);
		int actualValue = cart.getItemCount();
		assertNotEquals(itemCountBeforeAdd, actualValue);
	}
	
	@Test
	public void testAddProductNewBalance() {
		Product p1 = new Product("Tuna", 40.00);
		Product p2 = new Product("Sardines", 30.00);

		cart.addItem(p1);
		double balanceBeforeAdd = cart.getBalance();
		cart.addItem(p2);
		double actualValue = cart.getBalance();
		assertNotEquals(balanceBeforeAdd, actualValue);
	}
	
	@Test
	public void testDeleteroduct() {
		Product p1 = new Product("Tuna", 40.00);
		Product p2 = new Product("Sardines", 30.00);
		cart.addItem(p1);
		cart.addItem(p2);
		int itemCountBeforeAdd = cart.getItemCount();
		
		assertDoesNotThrow(() -> {
			cart.removeItem(p2);
			int actualValue = cart.getItemCount();
			assertNotEquals(itemCountBeforeAdd, actualValue);
		});
		
	}
	
	@Test
	public void testDeleteproductDoesNotExists() {
		Product p1 = new Product("Tuna", 40.00);
		Product p2 = new Product("Sardines", 30.00);
		Product p3 = new Product("Noodles", 10.00);
		cart.addItem(p1);
		cart.addItem(p2);
		
		assertDoesNotThrow(() -> {
			cart.removeItem(p3);
		});
		
	}
}
