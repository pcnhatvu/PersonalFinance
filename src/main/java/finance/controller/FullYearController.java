package finance.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import finance.model.Categories;
import finance.model.CategoryDetail;
import finance.model.FullYears;
import finance.model.Income;
import finance.service.FullYearService;
import finance.service.IncomeService;
import finance.service.IndexService;
import finance.utils.DateTimeService;

@Controller
public class FullYearController {
	
	@Autowired
	private IndexService indexService;
	
	@Autowired
	private FullYearService fullYearService;
	
	@Autowired
	private IncomeService incomeService;

	@RequestMapping("/full-year")
	public String allYearInfomation(@RequestParam("year") int year, Model model) {
		Categories categories = new Categories(indexService.listCategories());
		List<CategoryDetail> listCategoryDetail = fullYearService.listCategoryDetailBy(year);
		List<Income> incomes = incomeService.listIncomeBy(year);
		
		LocalDate currentdate = LocalDate.now();
		int currentMonth = currentdate.getMonth().ordinal() + 1;
		
		FullYears fullYears = FullYears.of(year, listCategoryDetail, categories.asList(), incomes);
		
		model.addAttribute("categories", categories);
		model.addAttribute("fullYears", fullYears.asList());
		model.addAttribute("incomes", incomes);
		model.addAttribute("year", year);
		model.addAttribute("currentMonth", currentMonth);
		model.addAttribute("currentYear", year);
		model.addAttribute("listMonth", DateTimeService.listMonth());
		model.addAttribute("listYear", DateTimeService.listYear());
		
		return "full-year";
	}
	
	@RequestMapping(value = "addIncome", method = RequestMethod.POST)
	@ResponseBody
	public Income addIncome(@RequestBody Income income, Model model) {
		incomeService.addIncome(income);
		return income;
	}
}
