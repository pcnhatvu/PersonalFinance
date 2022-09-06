package finance.model;

import java.math.BigDecimal;

import finance.model.core.Amount;
import finance.model.core.IncomeType;

public class Income {
	private int id;
	
	private IncomeType type;
	
	private int year;
	
	private int month;
	
	private Amount amount;
	
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IncomeType getType() {
		return type;
	}

	public void setType(IncomeType type) {
		this.type = type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = new Amount(amount);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isTheSameType(IncomeType another) {
		return this.type == another;
	}

	@Override
	public String toString() {
		return "Income [id=" + id + ", type=" + type + ", year=" + year + ", month=" + month + ", amount=" + amount
				+ ", name=" + name + "]";
	}
	
}
