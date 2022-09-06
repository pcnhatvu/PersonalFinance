package finance.model.core;

public enum IncomeType {
	MAIN,
	SIDE;
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
