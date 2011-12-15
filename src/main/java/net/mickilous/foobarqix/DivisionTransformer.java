package net.mickilous.foobarqix;

public class DivisionTransformer implements Transformer {

	@Override
	public String transform(int number) {
		StringBuffer sb = new StringBuffer();
		if (number % 3 == 0)
			sb.append("Foo");
		if (number % 5 == 0)
			sb.append("Bar");
		if (number % 7 == 0)
			sb.append("Qix");

		return sb.toString();
	}

}
