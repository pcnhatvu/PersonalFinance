package finance.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import finance.model.core.Amount;

public class FullYear {
	
	private int year;
	
	private int month;
	
	private BigDecimal amountOfBeginning;
	
	private BigDecimal mainIncome;
	
	private BigDecimal sideIncome;
	
	private List<Map<Integer, Amount>> listAmountByMonth;

	public FullYear() {
		super();
	}

	public FullYear(int year, int month, BigDecimal amountOfBeginning, BigDecimal mainIncome, BigDecimal sideIncome,
			List<Map<Integer, Amount>> listAmountByMonth) {
		super();
		this.year = year;
		this.month = month;
		this.amountOfBeginning = amountOfBeginning;
		this.mainIncome = mainIncome;
		this.sideIncome = sideIncome;
		this.listAmountByMonth = listAmountByMonth;
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

	public BigDecimal getAmountOfBeginning() {
		return amountOfBeginning;
	}

	public void setAmountOfBeginning(BigDecimal amountOfBeginning) {
		this.amountOfBeginning = amountOfBeginning;
	}

	public BigDecimal getMainIncome() {
		return mainIncome;
	}

	public void setMainIncome(BigDecimal mainIncome) {
		this.mainIncome = mainIncome;
	}

	public BigDecimal getSideIncome() {
		return sideIncome;
	}

	public void setSideIncome(BigDecimal sideIncome) {
		this.sideIncome = sideIncome;
	}

	public List<Map<Integer, Amount>> getListAmountByMonth() {
		return listAmountByMonth;
	}

	@Override
	public String toString() {
		return "FullYear [year=" + year + ", month=" + month + ", amountOfBeginning=" + amountOfBeginning
				+ ", mainIncome=" + mainIncome + ", sideIncome=" + sideIncome + ", listAmountByMonth="
				+ listAmountByMonth + "]";
	}
}
