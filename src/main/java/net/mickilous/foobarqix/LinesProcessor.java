package net.mickilous.foobarqix;

import java.io.OutputStream;
import java.io.PrintStream;

public class LinesProcessor {

	public static final int	MAX_NUMBER	= 100;
	private PrintStream		out;

	public void printLines() {
		for (int i = 1; i <= MAX_NUMBER; i++) {
			out.println(transform(i));
		}

	}

	public String transform(int i) {

		StringBuffer sb = new StringBuffer();

		testDivision(i, sb);
		testContains(i, sb);

		if (sb.length() == 0)
			sb.append(i);
		return sb.toString();

	}

	private void testDivision(int i, StringBuffer sb) {
		if (i % 3 == 0)
			sb.append("Foo");
		if (i % 5 == 0)
			sb.append("Bar");
		if (i % 7 == 0)
			sb.append("Qix");

	}

	private void testContains(int i, StringBuffer sb) {
		char[] number = String.valueOf(i).toCharArray();
		for (char digit : number) {
			if (digit == '3')
				sb.append("Foo");
			if (digit == '5')
				sb.append("Bar");
			if (digit == '7')
				sb.append("Qix");
		}
	}

	public void setOut(OutputStream out) {
		this.out = new PrintStream(out);
	}

}
