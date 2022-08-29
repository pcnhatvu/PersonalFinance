package finance.datasource;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import finance.model.CategoryDetail;

@Mapper
public interface FullYearMapper {
	
	public List<CategoryDetail> listCategoryDetailBy(@Param("categoryId") int categoryId, @Param("year") int year);
	
}
