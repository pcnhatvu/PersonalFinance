package finance.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import finance.model.Category;
import finance.model.CategoryDetail;
import finance.model.MonthOfYear;
import finance.service.IndexService;

@Controller
public class IndexController {
	
	@Autowired
	IndexService indexService;

	@RequestMapping("/index")
	public String index(@RequestParam("year") int year, @RequestParam("month") int month, Model model) {
		List<Category> listCategories = indexService.listCategories();
		model.addAttribute("listCategories", listCategories);
		
		for(Category category : listCategories) {
			List<CategoryDetail> listCategoryDetail = indexService.listCategoryDetailBy(category.getId(), month, year);
			category.setListCategoryDetail(listCategoryDetail);
		}
		
		model.addAttribute("currentMonth", month);
		model.addAttribute("listMonthOfYear", listMonthOfYear());
		
		return "index";
	}
	
	@RequestMapping()
	public String getCategoriesListBy() {
		LocalDate currentdate = LocalDate.now();
		int currentMonth = currentdate.getMonth().ordinal() + 1;
		int currentYear = currentdate.getYear();
		return "redirect:/index?year=" + currentYear + "&month=" + currentMonth;
	}
	
	@RequestMapping(value = "updatePriceByCategoryDetailId", method = RequestMethod.POST)
	@ResponseBody
	public BigDecimal updatePriceBy(@RequestParam("categoryDetailId") String categoryDetailId, @RequestParam("amount") String amount, Model model) {
		BigDecimal amountUsed = indexService.getAmountUsedBy(Integer.parseInt(categoryDetailId));
		BigDecimal newAmountUsed = amountUsed.add(new BigDecimal(amount));
		indexService.updateAmountUsedBy(Integer.parseInt(categoryDetailId), newAmountUsed);
		
		model.addAttribute("newAmountUsed", newAmountUsed);
		return newAmountUsed;
	}
	
	@RequestMapping(value = "addNewCategoryBy", method = RequestMethod.POST)
	@ResponseBody
	public CategoryDetail addNewCategoryBy(CategoryDetail newCategoryDetail, Model model) {
		indexService.addNewCategoryBy(newCategoryDetail);
		return newCategoryDetail;
	}
	
	@PostConstruct
	private List<MonthOfYear> listMonthOfYear() {
		List<MonthOfYear> listMonthOfYear = new ArrayList<MonthOfYear>();
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
