package tdd.example;

import java.math.BigDecimal;

public enum ProductCategory implements TaxRateAware {
	
	BOOK {
		@Override
		public BigDecimal taxRate() {
			return new BigDecimal(0);
		}
	}, 
	
	GENERAL {
		@Override
		public BigDecimal taxRate() {
			return new BigDecimal(0.1);
		}
		
	}, 
	
	FOOD {
		@Override
		public BigDecimal taxRate() {
			return new BigDecimal(0);
		}
	};

}
