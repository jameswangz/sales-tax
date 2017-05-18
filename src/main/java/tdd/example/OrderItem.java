package tdd.example;

import java.math.BigDecimal;

public class OrderItem {

	private int count;
	private Product product;

	public OrderItem(int count, Product product) {
		this.count = count;
		this.product = product;
	}

	public static OrderItem of(int count, Product product) {
		return new OrderItem(count, product);
	}

	public int getCount() {
		return count;
	}

	public Product getProduct() {
		return product;
	}

	public BigDecimal subtotal() {
		return new BigDecimal(count).multiply(product.priceWithTax());
	}

	public BigDecimal salesTax() {
		return new BigDecimal(count).multiply(product.salesTax());
	}

}
