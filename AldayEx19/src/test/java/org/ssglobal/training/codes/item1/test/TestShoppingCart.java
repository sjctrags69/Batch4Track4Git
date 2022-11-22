package org.ssglobal.training.codes.item1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.item1.Product;
import org.ssglobal.training.codes.item1.ProductNotFoundException;
import org.ssglobal.training.codes.item1.ShoppingCart;

import mockit.Expectations;
import mockit.Tested;

public class TestShoppingCart {

	@Tested
	private ShoppingCart sc;

	@Test
	public void testCreatCart() {
		
		new Expectations() {
			{
				@SuppressWarnings("unused")
				Product newCart = new Product(null, 0);
			}
		};
		int expect = 0;
		int actual = sc.getItemCount();
		assertEquals(expect, actual);
	}

	@Test
	public void testEmptyCart() {

		new Expectations() {
			{
				sc.empty();
			}
		};
		int expect = 0;
		int actual = sc.getItemCount();
		assertEquals(expect, actual);
	}

	@Test
	public void testAddProduct() {
		new Expectations() {
			{
				Product item = new Product("Pink Venom Album", 3000.0);
				sc.addItem(item);
			}
		};
		int expect = 1;
		int actual = sc.getItemCount();
		assertEquals(expect, actual);
		
	}
	
	@Test
	public void testAddProductNewBalance() {
		new Expectations() {
			{
				Product item = new Product("Pink Venom Album", 3000.0);
				sc.addItem(item);
				System.out.println(sc.getBalance());
				Product item2 = new Product("Sana D'Icon Album", 3000.0);
				Product item3 = new Product("Blackpink The Album", 3000.0);
				sc.addItem(item2);
				sc.addItem(item3);
				System.out.println(sc.getBalance());
			}
		};
		
		Double expect = 9000.0;
		Double actual = sc.getBalance();
		assertEquals(expect, actual);
	}
	
	@Test
	public void testDeleteProduct() {
		try {
			new Expectations() {
				{
					Product item = new Product("Sana D'Icon Album", 3000.0);
					Product item2 = new Product("Pink Venom Album", 3000.0);
					sc.addItem(item);
					sc.addItem(item2);
					sc.removeItem(item2);
				}
			};
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(1, sc.getItemCount());
	}
	
	@Test
	public void testDeleteproductDoesNotExist() throws ProductNotFoundException {
		new Expectations() {
			{
				Product item = new Product("Sana D'Icon Album", 3000.0);
				Product item2 = new Product("Pink Venom Album", 3000.0);
				sc.addItem(item);
				sc.addItem(item2);
			}
		};
		sc.removeItem(new Product("Formula of Love", 2000.0));
		assertEquals(1, sc.getItemCount());
	}


}
