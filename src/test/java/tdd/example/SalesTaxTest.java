package tdd.example;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Iterator;

import org.junit.Test;

import tdd.example.Order;
import tdd.example.OrderItem;
import tdd.example.ProductBuilder;
import tdd.example.ProductCategory;

public class SalesTaxTest {

	@Test
	public void case1() {
		Order order = new Order();
		order.add(OrderItem.of(1, new ProductBuilder().named("book").category(ProductCategory.BOOK).price($("12.49")).build()));
		order.add(OrderItem.of(1, new ProductBuilder().named("music CD").category(ProductCategory.GENERAL).price($("14.99")).build()));
		order.add(OrderItem.of(2, new ProductBuilder().named("chocolate bar").category(ProductCategory.FOOD).price($("0.85")).build()));
		
		Iterator<OrderItem> iterator = order.itemsIterator();
		
		OrderItem item1 = iterator.next();
		assertEquals(1, item1.getCount());
		assertEquals("book", item1.getProduct().getName());
		assertEquals($("12.49"), item1.subtotal());
		
		OrderItem item2 = iterator.next();
		assertEquals(1, item2.getCount());
		assertEquals("music CD", item2.getProduct().getName());
		assertEquals($("16.49"), item2.subtotal());
		
		OrderItem item3 = iterator.next();
		assertEquals(2, item3.getCount());
		assertEquals("chocolate bar", item3.getProduct().getName());
		assertEquals($("1.70"), item3.subtotal());
		
		assertEquals($("1.50"), order.salesTax());
		assertEquals($("30.68"), order.total());
	}

	private BigDecimal $(String value) {
		return new BigDecimal(value);
	}
	
	@Test
	public void case2() {
		Order order = new Order();
		order.add(OrderItem.of(1, new ProductBuilder().named("chocolate").imported().category(ProductCategory.FOOD).price($("10.00")).build()));
		order.add(OrderItem.of(1, new ProductBuilder().named("perfume").imported().category(ProductCategory.GENERAL).price($("47.50")).build()));
		
		Iterator<OrderItem> iterator = order.itemsIterator();
		
		OrderItem item1 = iterator.next();
		assertEquals(1, item1.getCount());
		assertEquals("chocolate", item1.getProduct().getName());
		assertTrue(item1.getProduct().isImported());
		assertEquals($("10.50"), item1.subtotal());
		
		OrderItem item2 = iterator.next();
		assertEquals(1, item2.getCount());
		assertEquals("perfume", item2.getProduct().getName());
		assertTrue(item2.getProduct().isImported());
		assertEquals($("54.65"), item2.subtotal());
		
		assertEquals($("7.65"), order.salesTax());
		assertEquals($("65.15"), order.total());
	}
	
	@Test
	public void case3() {
		Order order = new Order();
		order.add(OrderItem.of(1, new ProductBuilder().named("perfume").category(ProductCategory.GENERAL).imported().price($("27.99")).build()));
		order.add(OrderItem.of(1, new ProductBuilder().named("perfume").category(ProductCategory.GENERAL).price($("18.99")).build()));
		order.add(OrderItem.of(1, new ProductBuilder().named("headache pill").category(ProductCategory.MEDICAL).price($("9.75")).build()));
		order.add(OrderItem.of(1, new ProductBuilder().named("chocolate").category(ProductCategory.FOOD).imported().price($("11.25")).build()));
		
		Iterator<OrderItem> iterator = order.itemsIterator();
		OrderItem item1 = iterator.next();
		assertEquals(1, item1.getCount());
		assertTrue(item1.getProduct().isImported());
		assertEquals("perfume", item1.getProduct().getName());
		assertEquals($("32.19"), item1.subtotal());
		
		OrderItem item2 = iterator.next();
		assertEquals(1, item2.getCount());
		assertEquals("perfume", item2.getProduct().getName());
		assertEquals($("20.89"), item2.subtotal());
		
		OrderItem item3 = iterator.next();
		assertEquals(1, item3.getCount());
		assertEquals("headache pill", item3.getProduct().getName());
		assertEquals($("9.75"), item3.subtotal());
		
		OrderItem item4 = iterator.next();
		assertEquals(1, item4.getCount());
		assertTrue(item4.getProduct().isImported());
		assertEquals("chocolate", item4.getProduct().getName());
		assertEquals($("11.85"), item4.subtotal());
		
		assertEquals($("6.70"), order.salesTax());
		assertEquals($("74.68"), order.total());
	}
		
}