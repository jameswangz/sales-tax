package tdd.example;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Iterator;

import org.junit.Test;

public class SalesTaxTest {

	@Test
	public void case1() {
		Order order = new Order();
		order.add(OrderItem.of(1, new ProductBuilder().named("book").category(ProductCategory.BOOK).price(new BigDecimal("12.49")).build()));
		order.add(OrderItem.of(1, new ProductBuilder().named("music CD").category(ProductCategory.GENERAL).price(new BigDecimal("14.99")).build()));
		order.add(OrderItem.of(2, new ProductBuilder().named("chocolate bar").category(ProductCategory.FOOD).price(new BigDecimal("0.85")).build()));
		
		Iterator<OrderItem> iterator = order.itemsIterator();
		OrderItem item1 = iterator.next();
		assertEquals(1, item1.getCount());
		assertEquals("book", item1.getProduct().getName());
		assertEquals(new BigDecimal("12.49"), item1.subtotal());
		
		OrderItem item2 = iterator.next();
		assertEquals(1, item2.getCount());
		assertEquals("music CD", item2.getProduct().getName());
		assertEquals(new BigDecimal("16.49"), item2.subtotal());
		
		OrderItem item3 = iterator.next();
		assertEquals(2, item3.getCount());
		assertEquals("chocolate bar", item3.getProduct().getName());
		assertEquals(new BigDecimal("1.70"), item3.subtotal());
		
		assertEquals(new BigDecimal("1.50"), order.salesTaxes());
		assertEquals(new BigDecimal("30.68"), order.total());		
	}
	
	@Test
	public void case2() {
		Order order = new Order();
		order.add(OrderItem.of(1, new ProductBuilder().named("chocolates").category(ProductCategory.FOOD).imported().price(new BigDecimal("10.00")).build()));
		order.add(OrderItem.of(1, new ProductBuilder().named("perfume").category(ProductCategory.GENERAL).imported().price(new BigDecimal("47.50")).build()));
		
		Iterator<OrderItem> iterator = order.itemsIterator();
		OrderItem item1 = iterator.next();
		assertEquals(1, item1.getCount());
		assertEquals("chocolates", item1.getProduct().getName());
		assertEquals(new BigDecimal("10.50"), item1.subtotal());
		
		OrderItem item2 = iterator.next();
		assertEquals(1, item2.getCount());
		assertEquals("perfume", item2.getProduct().getName());
		assertEquals(new BigDecimal("54.65"), item2.subtotal());
		
		assertEquals(new BigDecimal("7.65"), order.salesTaxes());
		assertEquals(new BigDecimal("65.15"), order.total());	
	}
	
	@Test
	public void case3() {
		
	}
	
}
