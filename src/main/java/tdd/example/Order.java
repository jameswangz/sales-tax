package tdd.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Order {

	private List<OrderItem> items = new ArrayList<>();

	public void add(OrderItem item) {
		this.items.add(item);
	}

	public Iterator<OrderItem> itemsIterator() {
		return this.items.iterator();
	}

	public BigDecimal salesTaxes() {
		return items.stream().map(i -> i.salesTax()).reduce(new BigDecimal(0), (a, b) -> a.add(b)).setScale(2, BigDecimal.ROUND_CEILING);
	}

	public BigDecimal total() {
		return items.stream().map(i -> i.subtotal()).reduce(new BigDecimal(0), (a, b) -> a.add(b));
	}

}
