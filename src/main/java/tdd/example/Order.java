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
		return RoundingHelper.roundup(items.stream().map(i -> i.salesTax()).reduce(new BigDecimal(0), (a, b) -> a.add(b)));
	}

	public BigDecimal total() {
		return items.stream().map(i -> i.subtotal()).reduce(new BigDecimal(0), (a, b) -> a.add(b));
	}

}
