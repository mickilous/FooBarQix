package net.mickilous.foobarqix.transformers;

public class DivisionTransformer implements Transformer {

	@Override
	public String transform(int number) {
		StringBuffer sb = new StringBuffer();
		for (DigitEnum digit : DigitEnum.values()) {
			if (number % digit.getValue() == 0)
				sb.append(digit.getLabel());
		}
		return sb.toString();
	}

}
