package net.mickilous.foobarqix.transformers;

public class OccurencesTransformer implements Transformer {

	@Override
	public String transform(int number) {
		StringBuffer sb = new StringBuffer();
		char[] digits = String.valueOf(number).toCharArray();
		for (char digit : digits) {
			sb.append(transform(digit));
		}
		return sb.toString();
	}

	private String transform(char digit) {
		for (DigitEnum digitsEnum : DigitEnum.values()) {
			if (digitsEnum.getValue() == Character.getNumericValue(digit)) {
				return digitsEnum.getLabel();
			}
		}
		return "";
	}

}
