package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.Product;
import org.ssglobal.training.codes.ProductNotFoundException;
import org.ssglobal.training.codes.ShoppingCart;

import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;

public class TestShoppingCart {
	private Product item1 = new Product("Chips", 58.0);
	private Product item2 = new Product("Drinks", 80.0);
	
	@Tested
	private ShoppingCart cart;

	
	@Test
	public void testCreateCartSunnyDay() {
		int expectedValue = 0;
		int actualValue = cart.getItemCount();
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testEmptyCartSunnyDay() {
		cart.empty();
		int expectedValue = 0;
		int actualValue = cart.getItemCount();
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testAddProductSunnyDay() {
		cart.addItem(item1);
		int expectedValue = 1;
		int actualValue = cart.getItemCount();
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testAddProductNewBalanceSunnyDay() {
		cart.addItem(item1);
		cart.addItem(item2);
		double expectedValue = 138.0;
		double actualValue = cart.getBalance();
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testDeleteProductSunnyDay() {
		new MockUp<ShoppingCart>() {
			private ArrayList<Product> items = new ArrayList<>();
			
			@Mock
			public void removeItem(Product item) throws ProductNotFoundException, Exception  {
				if(!(items.contains(item))){
					throw new ProductNotFoundException();
				} else {
					items.remove(item);
				}
			}
		};
		
		assertThrows(ProductNotFoundException.class, () -> {
			cart.addItem(item1);
			cart.addItem(item2);
			cart.removeItem(item2);
			int expectedResult = 1;
			int actualResult = cart.getItemCount();
			assertEquals(expectedResult, actualResult);
			});
	}
	
	@Test
	public void testDeleteproductDoesNotExistsSunnyDay() {
		assertThrows(ProductNotFoundException.class, () -> {
			cart.removeItem(item2);
			int expectedResult = 0;
			int actualResult = cart.getItemCount();
			assertEquals(expectedResult, actualResult);
			});
	}
}
