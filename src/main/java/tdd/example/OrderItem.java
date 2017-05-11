package tdd.example;

import java.math.BigDecimal;

public class OrderItem {

	private int count;
	private Product product;
	private BigDecimal price;

	public OrderItem(int count, Product product, BigDecimal price) {
		this.count = count;
		this.product = product;
		this.price = price;
	}
	
	public static OrderItem of(int count, Product product, BigDecimal price) {
		return new OrderItem(count, product, price);
	}

	public int getCount() {
		return count;
	}

	public Product getProduct() {
		return product;
	}

	public BigDecimal subtotal() {
		return this.price.add(this.salesTax()).setScale(2, BigDecimal.ROUND_CEILING);
	}

	public BigDecimal salesTax() {
		return this.price.multiply(this.product.taxRate());
	}

}
