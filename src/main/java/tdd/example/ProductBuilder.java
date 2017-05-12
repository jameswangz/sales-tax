package tdd.example;

import java.math.BigDecimal;

public class ProductBuilder {

	private String name;
	private ProductCategory catetory;
	private BigDecimal price;
	private boolean imported;

	public ProductBuilder named(String name) {
		this.name = name;
		return this;
	}

	public ProductBuilder category(ProductCategory catetory) {
		this.catetory = catetory;
		return this;
	}
	
	public ProductBuilder price(BigDecimal price) {
		this.price = price;
		return this;
	}
	
	public Product build() {
		Product product = new Product(name, catetory, price);
		product.setImported(imported);
		return product;
	}

	public ProductBuilder imported() {
		this.imported  = true;
		return this;
	}

	



}
