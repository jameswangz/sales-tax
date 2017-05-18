package tdd.example;

import java.math.BigDecimal;

public interface TaxRateStrategy {

	default BigDecimal taxRate() {
		return new BigDecimal("0");
	}

}