package finance.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import finance.model.Categories;
import finance.model.Category;
import finance.model.CategoryDetail;
import finance.service.IndexService;
import finance.utils.DateTimeService;

@Controller
public class IndexController {
	
	@Autowired
	private IndexService indexService;

	@RequestMapping("/index")
	public String index(@RequestParam("year") int year, @RequestParam("month") int month, Model model) {
		if(month == 0) {
			return "redirect:/full-year?year=" + year;
		}
		
		
		Categories categories = new Categories(indexService.listCategories());
		
		for(Category category : categories.asList()) {
			List<CategoryDetail> listCategoryDetail = indexService.listCategoryDetailBy(category.getId(), month, year);
			category.setListCategoryDetail(listCategoryDetail);
		}
		
		model.addAttribute("categories", categories);
		model.addAttribute("currentMonth", month);
		model.addAttribute("currentYear", year);
		model.addAttribute("listMonth", DateTimeService.listMonth());
		model.addAttribute("listYear", DateTimeService.listYear());
		
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
}
