package finance.utils;

import java.util.ArrayList;
import java.util.List;

import finance.model.MonthOfYear;

public class DateTimeService {

	public static List<MonthOfYear> listMonthOfYear() {
		List<MonthOfYear> listMonthOfYear = new ArrayList<MonthOfYear>();
		listMonthOfYear.add(new MonthOfYear(0, "Full Year"));
		listMonthOfYear.add(new MonthOfYear(1, "January"));
		listMonthOfYear.add(new MonthOfYear(2, "Febuary"));
		listMonthOfYear.add(new MonthOfYear(3, "March"));
		listMonthOfYear.add(new MonthOfYear(4, "April"));
		listMonthOfYear.add(new MonthOfYear(5, "May"));
		listMonthOfYear.add(new MonthOfYear(6, "June"));
		listMonthOfYear.add(new MonthOfYear(7, "July"));
		listMonthOfYear.add(new MonthOfYear(8, "August"));
		listMonthOfYear.add(new MonthOfYear(9, "September"));
		listMonthOfYear.add(new MonthOfYear(10, "October"));
		listMonthOfYear.add(new MonthOfYear(11, "November"));
		listMonthOfYear.add(new MonthOfYear(12, "December"));
		
		return listMonthOfYear;
	}
}
