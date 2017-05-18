package tdd.example;

import java.math.BigDecimal;

public class Product {

	private String name;
	private TaxRateStrategy category;
	private BigDecimal price;
	private boolean imported;

	public Product(String name, ProductCategory category, BigDecimal price) {
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public BigDecimal priceWithTax() {
		return price.add(salesTax()).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	BigDecimal salesTax() {
		return round(price.multiply(taxRate()));
	}

	private BigDecimal round(BigDecimal value) {
		double roundTo = 0.05;
		return new BigDecimal(Math.ceil(value.doubleValue() / roundTo) * roundTo);
	}

	private BigDecimal taxRate() {
		BigDecimal taxRate = category.taxRate();
		if (imported) {
			taxRate = taxRate.add(new BigDecimal("0.05"));
		}
		return taxRate;
	}
	
	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

}
