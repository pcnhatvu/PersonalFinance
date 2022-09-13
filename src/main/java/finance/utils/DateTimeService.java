package finance.utils;

import java.util.ArrayList;
import java.util.List;


import finance.model.core.Month;
import finance.model.core.Year;

public class DateTimeService {

	public static List<Month> listMonth() {
		List<Month> listMonth = new ArrayList<Month>();
		listMonth.add(new Month(0, "Full Year"));
		listMonth.add(new Month(1, "January"));
		listMonth.add(new Month(2, "Febuary"));
		listMonth.add(new Month(3, "March"));
		listMonth.add(new Month(4, "April"));
		listMonth.add(new Month(5, "May"));
		listMonth.add(new Month(6, "June"));
		listMonth.add(new Month(7, "July"));
		listMonth.add(new Month(8, "August"));
		listMonth.add(new Month(9, "September"));
		listMonth.add(new Month(10, "October"));
		listMonth.add(new Month(11, "November"));
		listMonth.add(new Month(12, "December"));
		
		return listMonth;
	}
	
	public static List<Year> listYear() {
		List<Year> listYear = new ArrayList<Year>();
		listYear.add(new Year(2022, "2022"));
		listYear.add(new Year(2023, "2023"));
		
		return listYear;
	}
}
