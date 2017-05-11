package tdd.example;

public class ProductBuilder {

	private String name;
	private ProductCategory catetory;

	public ProductBuilder named(String name) {
		this.name = name;
		return this;
	}

	public ProductBuilder category(ProductCategory catetory) {
		this.catetory = catetory;
		return this;
	}

	public Product build() {
		Product product = new Product(name, catetory);
		return product;
	}



}
