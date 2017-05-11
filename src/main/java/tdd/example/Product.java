package tdd.example;

import java.math.BigDecimal;

public class Product {

	private String name;
	private ProductCategory catetory;
	private BigDecimal price;

	public Product(String name, ProductCategory catetory, BigDecimal price) {
		this.name = name;
		this.catetory = catetory;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public BigDecimal taxRate() {
		return this.catetory.taxRate();
	}

	public BigDecimal priceWithTax() {
		return this.price.add(salesTax());
	}

	public BigDecimal salesTax() {
		return this.price.multiply(catetory.taxRate());	
	}

}
