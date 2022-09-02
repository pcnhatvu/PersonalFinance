package finance.model;

import java.math.BigDecimal;

import finance.model.core.Amount;

public class CategoryDetail {
	
	private int id;
	
	private String name;
	
	private Amount amountUsed;
	
	private int categoryId;
	
	private int year;
	
	private int month;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Amount getAmountUsed() {
		return amountUsed;
	}

	public void setAmountUsed(BigDecimal amountUsed) {
		this.amountUsed = new Amount(amountUsed);
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	@Override
	public String toString() {
		return "CategoryDetail [id=" + id + ", name=" + name + ", amountUsed=" + amountUsed + ", categoryId="
				+ categoryId + ", year=" + year + ", month=" + month + "]";
	}
	
}
