package finance.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private int id;
	
	private String name;
	
	private List<CategoryDetail> listCategoryDetail = new ArrayList<CategoryDetail>();

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

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", listCategoryDetail=" + listCategoryDetail + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getListCategoryDetail()=" + getListCategoryDetail()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
