package finance.datasource;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import finance.model.Category;
import finance.model.CategoryDetail;

@Mapper
public interface IndexMapper {

	public List<Category> listCategories();
	
	public List<CategoryDetail> listCategoryDetailBy(@Param("categoryId") int categoryId, @Param("month") int month, @Param("year") int year);
	
	public BigDecimal getAmountUsedBy(@Param("categoryId") int categoryId);
	
	public void updateAmountUsedBy(@Param("categoryId") int categoryId, @Param("newAmountUsed") BigDecimal newAmountUsed);

	public void addNewCategoryBy(@Param("newCategoryDetail") CategoryDetail newCategoryDetail);
}
