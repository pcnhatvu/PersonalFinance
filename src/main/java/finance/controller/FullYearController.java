package finance.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import finance.model.Category;
import finance.model.CategoryDetail;
import finance.model.FullYear;
import finance.service.FullYearService;
import finance.service.IndexService;
import finance.utils.DateTimeService;

@Controller
public class FullYearController {
	
	@Autowired
	IndexService indexService;
	
	@Autowired
	FullYearService fullYearService;

	@RequestMapping("/full-year")
	public String allYearInfomation(@RequestParam("year") int year, Model model) {

		List<CategoryDetail> listCategoryDetail = fullYearService.listCategoryDetailBy(year);
		
		List<FullYear> listFullYear = of(year, listCategoryDetail);
		
		model.addAttribute("listCategories", listCategoryDetail);
		model.addAttribute("year", year);
		model.addAttribute("listMonthOfYear", DateTimeService.listMonthOfYear());
		return "full-year";
	}
	
	private List<FullYear> of(int year, List<CategoryDetail> listCategoryDetail) {
		List<FullYear> listFullYears = new ArrayList<FullYear>();
		List<Map<Integer, BigDecimal>> listAmountByMonthList = new ArrayList<Map<Integer,BigDecimal>>();
		
		//for(int i = 1 ; i <= 12 ; i++) {
			Map<Integer, Long> amountByMonth = new HashMap<Integer, Long>();
			Long amount = getAmountOfMoneyBy(4, 1, listCategoryDetail);
			amountByMonth.put(Integer.valueOf(4), amount);

			//listAmountByMonthList.add(amountByMonth);
		//}
			
		FullYear fullYear = new FullYear(year, 1, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, listAmountByMonthList);
		System.out.println(fullYear);
		return null;
	}
	
	private Long getAmountOfMoneyBy(int month, int categoryId, List<CategoryDetail> listCategoryDetails) {
		return listCategoryDetails.stream()
						.filter(categoryDetail -> categoryDetail.getCategoryId() == categoryId && categoryDetail.getMonth() == month)
						.mapToLong(listCategoryDetail -> listCategoryDetail.getLongValueOfAmountUsed())
						.sum();
	}
}
