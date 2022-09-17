package finance.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Categories {
	DecimalFormat formatter = new DecimalFormat("###,###,###");
	
	private List<Category> values = new ArrayList<Category>();

	public Categories() {
	}

	public Categories(List<Category> values) {
		this.values = values;
	}

	public List<Category> getValues() {
		return values;
	}

	public void setValues(List<Category> values) {
		this.values = values;
	}
	
	public int totalSpend() {
		return values.stream()
				.mapToInt(category -> category.totalOfAmountUsedBy(category.getListCategoryDetail()))
				.sum();
	}
	
	public String asTextTotal() {
		return formatter.format(totalSpend()) + " VNĐ";
	}
	
	public List<Category> asList() {
		return values;
	}
}
