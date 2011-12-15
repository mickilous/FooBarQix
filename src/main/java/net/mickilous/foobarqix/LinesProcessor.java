package net.mickilous.foobarqix;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import net.mickilous.foobarqix.transformers.Transformer;

public class LinesProcessor {

	public static final int		MAX_NUMBER	= 100;
	private PrintStream			out;
	private List<Transformer>	transformers;

	public void printLines() {
		for (int i = 1; i <= MAX_NUMBER; i++) {
			out.println(transformLine(i));
		}
	}

	public String transformLine(int i) {

		StringBuffer sb = new StringBuffer();

		for (Transformer t : transformers)
			sb.append(t.transform(i));

		if (sb.length() == 0)
			sb.append(i);

		return sb.toString();

	}

	public void setOutputStream(OutputStream out) {
		this.out = new PrintStream(out);
	}

	public void setTransformers(Transformer... transformer) {
		this.transformers = Arrays.asList(transformer);
	}

}
