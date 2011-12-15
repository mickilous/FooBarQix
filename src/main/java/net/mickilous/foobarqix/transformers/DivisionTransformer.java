package net.mickilous.foobarqix.transformers;

public class DivisionTransformer implements Transformer {

	@Override
	public String transform(int number) {
		StringBuffer sb = new StringBuffer();
		for (DigitEnum digit : DigitEnum.values()) {
			if (isDividable(number, digit.getValue()))
				sb.append(digit.getLabel());
		}
		return sb.toString();
	}

	private boolean isDividable(int number, int value) {
		return number % value == 0;
	}

}
