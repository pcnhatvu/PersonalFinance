package finance.model;

public class MonthOfYear {
	private String value;
	
	private int key;
	
	public MonthOfYear(int key, String value) {
		super();
		this.value = value;
		this.key = key;
	}

	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}

}
