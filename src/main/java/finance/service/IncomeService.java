package finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finance.datasource.IncomeMapper;
import finance.model.Income;

@Service
public class IncomeService {
	
	@Autowired
	private IncomeMapper incomeMapper;
	
	public void addIncome(Income income) {
		incomeMapper.addIncome(income);
	}

	public List<Income> listIncomeBy(int year) {
		return incomeMapper.listIncomeBy(year);
	}
}
