package finance.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import finance.model.core.Amount;

public class FullYear {
	
	private int year;
	
	private int month;
	
	private Amount amountOfBeginning = Amount.ofDefault();
	
	private Amount mainIncome;
	
	private Amount sideIncome;
	
	private List<Map<Integer, Amount>> listAmountByMonth;
	
	private Map<Integer, Amount> listTotalOfMonth = new HashMap<Integer, Amount>();

	public FullYear() {
		super();
	}

	public FullYear(int year, int month, Amount mainIncome, Amount sideIncome,
			List<Map<Integer, Amount>> listAmountByMonth) {
		super();
		this.year = year;
		this.month = month;
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

	public void setAmountOfBeginning(Amount amountOfBeginning) {
		this.amountOfBeginning = amountOfBeginning;
	}

	public Amount getAmountOfBeginning() {
		return amountOfBeginning;
	}

	public Amount getMainIncome() {
		return mainIncome;
	}

	public void setMainIncome(Amount mainIncome) {
		this.mainIncome = mainIncome;
	}

	public Amount getSideIncome() {
		return sideIncome;
	}

	public void setSideIncome(BigDecimal sideIncome) {
		this.sideIncome = new Amount(sideIncome);
	}

	public List<Map<Integer, Amount>> getListAmountByMonth() {
		return listAmountByMonth;
	}

	public Map<Integer, Amount> getListTotalOfMonth() {
		return listTotalOfMonth;
	}

	public void setListTotalOfMonth(Map<Integer, Amount> listTotalOfMonth) {
		this.listTotalOfMonth = listTotalOfMonth;
	}
	
	public Amount totalIncome() {
		return new Amount(mainIncome.getAmount().add(sideIncome.getAmount()));
	}
	
//	public Amount amountOfBeginning() {
//		if(month == 4 && year == 2022)
//			return new Amount(new BigDecimal(0));
//		return new Amount(amountRemaining().getAmount().add(totalIncome().getAmount()).subtract(totalUsedByMonth().getAmount()));
//	}
	
	public Amount amountRemaining() {
		return new Amount(amountOfBeginning.getAmount().add(totalIncome().getAmount().subtract(totalUsedByMonth().getAmount())));
	}
	
	public Amount totalUsedByMonth() {
		return new Amount(new BigDecimal(listTotalOfMonth.entrySet().stream()
				.mapToLong(amount -> amount.getValue().getLongValueOfAmount())
				.sum()));
				
	}

	@Override
	public String toString() {
		return "FullYear [year=" + year + ", month=" + month + ", mainIncome=" + mainIncome + ", sideIncome="
				+ sideIncome + ", listAmountByMonth=" + listAmountByMonth + ", listTotalOfMonth=" + listTotalOfMonth
				+ "]";
	}
}
