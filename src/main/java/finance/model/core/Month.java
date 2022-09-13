package finance.model.core;

public class Month {
	private String value;
	
	private int key;
	
	public Month(int key, String value) {
		this.value = value;
		this.key = key;
	}

	public String getValue() {
		return value;
	}
	
	public int getKey() {
		return key;
	}
}
