package finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finance.datasource.FullYearMapper;
import finance.model.CategoryDetail;

@Service
public class FullYearService {

	@Autowired
	private FullYearMapper fullYearMapper;
	
	public List<CategoryDetail> listCategoryDetailBy(int year) {
		return fullYearMapper.listCategoryDetailBy(year);
	}
	
}
