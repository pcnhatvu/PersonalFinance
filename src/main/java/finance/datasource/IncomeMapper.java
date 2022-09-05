package finance.datasource;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import finance.model.Income;

@Mapper
public interface IncomeMapper {

	public void addIncome(@Param("income") Income income);

	public List<Income> listIncomeBy(@Param("year") int year);
}
