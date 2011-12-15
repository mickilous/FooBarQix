package net.mickilous.foobarqix.transformers;

public enum DigitEnum {

	FOO(3, "Foo"), BAR(5, "Bar"), QIX(7, "Qix");

	private int		value;
	private String	label;

	private DigitEnum(int value, String label) {
		this.value = value;
		this.label = label;
	}

	public int getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}

}
