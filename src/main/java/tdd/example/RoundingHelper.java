package tdd.example;

import java.math.BigDecimal;

public class RoundingHelper {

	public static BigDecimal roundup(BigDecimal value) {
		double roundto = 0.05;
		return new BigDecimal(Math.ceil(value.doubleValue() / roundto ) * roundto).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

}
