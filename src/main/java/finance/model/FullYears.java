package finance.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import finance.model.core.Amount;
import finance.model.core.IncomeType;

public class FullYears {
	
	private List<FullYear> fullYears = new ArrayList<FullYear>();

	public FullYears() {
	}

	public FullYears(List<FullYear> fullYears) {
		this.fullYears = fullYears;
	}
	
	public List<FullYear> asList() {
		return fullYears;
	}

	public static FullYears of(int year, List<CategoryDetail> listCategoryDetail, List<Category> categories, List<Income> listIncome) {
		List<FullYear> listFullYears = new ArrayList<FullYear>();
		
		for(int month = 1 ; month <= 12 ; month++) {
			List<Map<Integer, Amount>> listAmountByMonthList = getAmountOfMoneyBy(month, listCategoryDetail, categories);
			FullYear fullYear = new FullYear(year, month, new Amount(totalIncomeBy(month, listIncome, IncomeType.MAIN)), new Amount(totalIncomeBy(month, listIncome, IncomeType.SIDE)), listAmountByMonthList);
			Map<Integer, Amount> listTotalOfMonth = totalOfMonthBy(month, listCategoryDetail);
			
			fullYear.setAmountOfBeginning(month == 4 ? Amount.ofDefault() : 
				new Amount(totalIncomeBy(month - 1, listIncome).subtract(totalUsedOfPreviousMonth(month - 1, listCategoryDetail))));
			fullYear.setListTotalOfMonth(listTotalOfMonth);
			BigDecimal totalPreviousIncome = totalIncomeBy(month - 1, listIncome);
			BigDecimal totalUsedOfPreviousMonth = totalUsedOfPreviousMonth(month - 1, listCategoryDetail);
			BigDecimal amountOfPreviousRemaining = new BigDecimal(0);
			if(month >= 3) {
				amountOfPreviousRemaining = listFullYears.get(month - 3).getAmountOfBeginning().getAmount();
			}
			BigDecimal remainingOfPreviosTotal = totalIncomeBy(month - 2, listIncome).subtract(totalUsedOfPreviousMonth(month - 2, listCategoryDetail)).add(amountOfPreviousRemaining);
			BigDecimal remainingTotal = totalPreviousIncome.add(remainingOfPreviosTotal).subtract(totalUsedOfPreviousMonth);
			fullYear.setAmountOfBeginning(new Amount(remainingTotal));
			listFullYears.add(fullYear);
		}
		
		return new FullYears(listFullYears);
	}
	
	private static List<Map<Integer, Amount>> getAmountOfMoneyBy(int month, List<CategoryDetail> listCategoryDetails, List<Category> categories) {
		List<Map<Integer, Amount>> listAmountByMonthList = new ArrayList<Map<Integer,Amount>>();
		
		categories.stream().forEach(category -> {
			Map<Integer, Amount> amountByMonth = new HashMap<Integer, Amount>();
			BigDecimal amount = new BigDecimal(listCategoryDetails.stream()
					.filter(categoryDetail -> categoryDetail.getMonth() == month &&  categoryDetail.getCategoryId() == category.getId())
					.mapToLong(listCategoryDetail -> listCategoryDetail.getAmountUsed().getLongValueOfAmount())
					.sum());
			amountByMonth.put(category.getId(), new Amount(amount));
			listAmountByMonthList.add(amountByMonth);
		});
		
		return listAmountByMonthList;
	}
	
	private static Map<Integer, Amount> totalOfMonthBy(int month, List<CategoryDetail> listCategoryDetail) {
		Map<Integer, Amount> listTotalOfMonth = new HashMap<Integer, Amount>();
		
		BigDecimal amount = totalUsedOfPreviousMonth(month, listCategoryDetail);
		
		listTotalOfMonth.put(Integer.valueOf(month), new Amount(amount));
		
		return listTotalOfMonth;
	}
	
	private static BigDecimal totalIncomeBy(int month, List<Income> listIncome, IncomeType type) {
		return new BigDecimal(listIncome.stream()
				.filter(income -> income.getMonth() == month && income.isTheSameType(type))
				.mapToLong(income -> income.getAmount().getLongValueOfAmount())
				.sum());
	}
	
	private static BigDecimal totalIncomeBy(int month, List<Income> listIncome) {
		return new BigDecimal(listIncome.stream()
				.filter(income -> income.getMonth() == month)
				.mapToLong(income -> income.getAmount().getLongValueOfAmount())
				.sum());
	}
	
	private static BigDecimal totalUsedOfPreviousMonth(int month, List<CategoryDetail> listCategoryDetail) {
		return new BigDecimal(listCategoryDetail.stream()
				.filter(categoryDetail -> categoryDetail.getMonth() == month)
				.mapToLong(categoryDetail -> categoryDetail.getAmountUsed().getLongValueOfAmount())
				.sum());
	}
}
