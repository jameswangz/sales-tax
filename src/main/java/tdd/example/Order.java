package tdd.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BinaryOperator;

public class Order {

	private List<OrderItem> items = new ArrayList<>();

	public void add(OrderItem item) {
		this.items .add(item);
	}

	public Iterator<OrderItem> itemsIterator() {
		return items.iterator();
	}

	public BigDecimal salesTax() {
		return scaled(items.stream().map(i -> i.salesTax()).reduce(new BigDecimal("0"), accumulator()));
	}

	private BigDecimal scaled(BigDecimal value) {
		return value.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	private BinaryOperator<BigDecimal> accumulator() {
		return (a, b) -> a.add(b);
	}

	public BigDecimal total() {
		return scaled(items.stream().map(i -> i.subtotal()).reduce(new BigDecimal("0"), accumulator()));
	}

}
