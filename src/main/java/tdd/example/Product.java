package tdd.example;

import java.math.BigDecimal;

public class Product {

	private String name;
	private ProductCategory catetory;

	public Product(String name, ProductCategory catetory) {
		this.name = name;
		this.catetory = catetory;
	}

	public String getName() {
		return name;
	}

	public BigDecimal taxRate() {
		return this.catetory.taxRate();
	}

}
