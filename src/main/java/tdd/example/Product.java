package tdd.example;

import java.math.BigDecimal;

public class Product {

	private String name;
	private ProductCategory catetory;
	private BigDecimal price;
	private boolean imported;

	public Product(String name, ProductCategory catetory, BigDecimal price) {
		this.name = name;
		this.catetory = catetory;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public BigDecimal taxRate() {
		BigDecimal importedTaxRate = imported ? new BigDecimal(0.05) : new BigDecimal(0);
		return this.catetory.taxRate().add(importedTaxRate);
	}

	public BigDecimal priceWithTax() {
		return this.price.add(salesTax());
	}

	public BigDecimal salesTax() {
		return RoundingHelper.roundup(this.price.multiply(taxRate()));	
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

}
