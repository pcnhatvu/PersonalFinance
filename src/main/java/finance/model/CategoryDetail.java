package finance.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CategoryDetail {
	
	private int id;
	
	private String name;
	
	private BigDecimal amountUsed;
	
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

	public BigDecimal getAmountUsed() {
		return amountUsed;
	}

	public void setAmountUsed(BigDecimal amountUsed) {
		this.amountUsed = amountUsed;
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
	
	DecimalFormat formatter = new DecimalFormat("###,###,###");
	
	public String asText() {
		return formatter.format(this.amountUsed) + " VNĐ";
	}
	
	public long getLongValueOfAmountUsed() {
		return amountUsed.longValue();
	}

	@Override
	public String toString() {
		return "CategoryDetail [id=" + id + ", name=" + name + ", amountUsed=" + amountUsed + ", categoryId="
				+ categoryId + ", year=" + year + ", month=" + month + ", formatter=" + formatter + "]";
	}
	
}
