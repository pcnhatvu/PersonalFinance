package finance.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Category {

	private int id;
	
	private String name;
	
	private List<CategoryDetail> listCategoryDetail = new ArrayList<CategoryDetail>();
	
	private int total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CategoryDetail> getListCategoryDetail() {
		return listCategoryDetail;
	}

	public void setListCategoryDetail(List<CategoryDetail> listCategoryDetail) {
		this.listCategoryDetail = listCategoryDetail;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public int totalOfAmount() {
		return listCategoryDetail.stream().mapToInt(categoryDetail -> categoryDetail.getAmountUsed().intValue()).sum();
	}
	
	DecimalFormat formatter = new DecimalFormat("###,###,###");
	
	public String asTextTotal() {
		return "Total: " + formatter.format(totalOfAmount()) + " VNĐ";
	}
	
	public String asTextTotalTable() {
		return formatter.format(totalOfAmount()) + " VNĐ";
	}
}
