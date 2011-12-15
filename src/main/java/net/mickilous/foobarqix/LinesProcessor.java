package net.mickilous.foobarqix;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class LinesProcessor {

	public static final int		MAX_NUMBER		= 100;
	private PrintStream			out;
	private List<Transformer>	transformers	= Arrays.asList(new DivisionTransformer(), new OccurencesTransformer());

	public void printLines() {
		for (int i = 1; i <= MAX_NUMBER; i++) {
			out.println(transform(i));
		}

	}

	public String transform(int i) {

		StringBuffer sb = new StringBuffer();

		for (Transformer t : transformers)
			sb.append(t.transform(i));

		if (sb.length() == 0)
			sb.append(i);

		return sb.toString();

	}

	public void setOut(OutputStream out) {
		this.out = new PrintStream(out);
	}

	public void setTransformers(List<Transformer> transformers) {
		this.transformers = transformers;
	}

}
