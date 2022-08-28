package finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import finance.model.Category;
import finance.service.IndexService;
import finance.utils.DateTimeService;

@Controller
public class FullYearController {
	
	@Autowired
	IndexService indexService;

	@RequestMapping("/full-year")
	public String allYearInfomation(@RequestParam("year") int year, Model model) {
		
		List<Category> listCategories = indexService.listCategories();
		
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("year", year);
		model.addAttribute("listMonthOfYear", DateTimeService.listMonthOfYear());
		return "full-year";
	}
}
