package tdd.example;

import java.math.BigDecimal;

public enum ProductCategory implements TaxRateStrategy {
	
	BOOK , 
	GENERAL {
		@Override
		public BigDecimal taxRate() {
			return new BigDecimal(0.1);
		}
	}, 
	
	FOOD, 
	MEDICAL;

}
