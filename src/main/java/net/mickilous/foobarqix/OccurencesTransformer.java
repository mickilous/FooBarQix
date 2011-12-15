package net.mickilous.foobarqix;

public class OccurencesTransformer implements Transformer {

	@Override
	public String transform(int number) {
		StringBuffer sb = new StringBuffer();
		char[] digits = String.valueOf(number).toCharArray();
		for (char digit : digits) {
			if (digit == '3')
				sb.append("Foo");
			if (digit == '5')
				sb.append("Bar");
			if (digit == '7')
				sb.append("Qix");
		}
		return sb.toString();
	}

}
