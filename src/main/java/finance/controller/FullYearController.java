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
		List<Category> categories = indexService.listCategories();
		List<CategoryDetail> listCategoryDetail = fullYearService.listCategoryDetailBy(year);
		
		List<FullYear> fullYears = of(year, listCategoryDetail, categories);
		
		model.addAttribute("categories", categories);
		model.addAttribute("fullYears", fullYears);
		model.addAttribute("year", year);
		model.addAttribute("listMonthOfYear", DateTimeService.listMonthOfYear());
		return "full-year";
	}
	
	private List<FullYear> of(int year, List<CategoryDetail> listCategoryDetail, List<Category> categories) {
		List<FullYear> listFullYears = new ArrayList<FullYear>();
		
		
		for(int i = 1 ; i <= 12 ; i++) {
			List<Map<Integer, BigDecimal>> listAmountByMonthList = getAmountOfMoneyBy(i, listCategoryDetail, categories);
			FullYear fullYear = new FullYear(year, i, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, listAmountByMonthList);
			listFullYears.add(fullYear);
		}
		
		System.out.println(listFullYears);
		
		return listFullYears;
	}
	
	private List<Map<Integer, BigDecimal>> getAmountOfMoneyBy(int month, List<CategoryDetail> listCategoryDetails, List<Category> categories) {
		List<Map<Integer, BigDecimal>> listAmountByMonthList = new ArrayList<Map<Integer,BigDecimal>>();
		
		categories.stream().forEach(category -> {
			Map<Integer, BigDecimal> amountByMonth = new HashMap<Integer, BigDecimal>();
			BigDecimal amount = new BigDecimal(listCategoryDetails.stream()
					.filter(categoryDetail -> categoryDetail.getMonth() == month &&  categoryDetail.getCategoryId() == category.getId())
					.mapToLong(listCategoryDetail -> listCategoryDetail.getLongValueOfAmountUsed())
					.sum());
			amountByMonth.put(category.getId(), amount);
			listAmountByMonthList.add(amountByMonth);
		});
		
		return listAmountByMonthList;
	}
}
