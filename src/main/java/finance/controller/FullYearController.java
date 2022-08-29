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
		
		List<Category> listCategories = indexService.listCategories();
		
		for (Category category : listCategories) {
			List<CategoryDetail> listCategoryDetail = fullYearService.listCategoryDetailBy(category.getId(), year);
			category.setListCategoryDetail(listCategoryDetail);
		}
		
		List<FullYear> listFullYear = of(year, listCategories);
		
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("year", year);
		model.addAttribute("listMonthOfYear", DateTimeService.listMonthOfYear());
		return "full-year";
	}
	
	private List<FullYear> of(int year, List<Category> listCategories) {
		List<FullYear> listFullYears = new ArrayList<FullYear>();
		List<Map<Integer, BigDecimal>> listAmountByMonthList = new ArrayList<Map<Integer,BigDecimal>>();
		
			listCategories.forEach(category -> {
				for(int i = 1 ; i <= 12 ; i++) {
				Map<Integer, BigDecimal> amountByMonth = new HashMap<Integer, BigDecimal>();
				BigDecimal amount = getAmountOfMoneyBy(i, category.getId(), category.getListCategoryDetail());
				amountByMonth.put(Integer.valueOf(i), amount);

				listAmountByMonthList.add(amountByMonth);
				}
			});
			
		FullYear fullYear = new FullYear(year, 1, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, listAmountByMonthList);
		System.out.println(fullYear);
		return null;
	}
	
	private BigDecimal getAmountOfMoneyBy(int month, int categoryId, List<CategoryDetail> listCategoryDetails) {
		return BigDecimal.valueOf(
				listCategoryDetails.stream()
						.mapToDouble(listCategoryDetail -> listCategoryDetail.getLongValueOfAmountUsed())
						.sum());
	}
}
