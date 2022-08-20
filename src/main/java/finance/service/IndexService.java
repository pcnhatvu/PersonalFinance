package finance.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finance.datasource.IndexMapper;
import finance.model.Category;
import finance.model.CategoryDetail;

@Service
public class IndexService {

	@Autowired
	IndexMapper indexMapper;
	
	public List<Category> listCategories() {
		return indexMapper.listCategories();
	}
	
	public List<CategoryDetail> listCategoryDetailBy(int categoryId, int month, int year) {
		return indexMapper.listCategoryDetailBy(categoryId, month, year);
	}
	
	public BigDecimal getAmountUsedBy(int categoryId) {
		return indexMapper.getAmountUsedBy(categoryId);
	}
	
	public void updateAmountUsedBy(int categoryId, BigDecimal newAmountUsed) {
		indexMapper.updateAmountUsedBy(categoryId, newAmountUsed);
	}
	
	public void addNewCategoryBy(CategoryDetail newCategoryDetail) {
		indexMapper.addNewCategoryBy(newCategoryDetail);
	}
}
