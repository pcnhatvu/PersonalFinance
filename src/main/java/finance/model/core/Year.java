package finance.model.core;

public class Year {
	private String value;
	
	private int key;
	
	public Year(int key, String value) {
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
