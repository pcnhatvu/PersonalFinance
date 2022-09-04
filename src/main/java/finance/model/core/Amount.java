package finance.model.core;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Amount{
	private DecimalFormat formatter = new DecimalFormat("###,###,###");
	
	private BigDecimal value;
	
	public Amount() {
	}

	public Amount(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getAmount() {
		return value;
	}

	public void setAmount(BigDecimal amount) {
		this.value = amount;
	}

	public String asText() {
		return formatter.format(value) + " VNĐ";
	}
	
	public long getLongValueOfAmount() {
		return value.longValue();
	}
	
	public int getIntValueOfAmount() {
		return value.intValue();
	}

	@Override
	public String toString() {
		return "Amount [value=" + value + "]";
	}
}
