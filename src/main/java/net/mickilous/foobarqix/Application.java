package net.mickilous.foobarqix;

import net.mickilous.foobarqix.transformers.DivisionTransformer;
import net.mickilous.foobarqix.transformers.OccurencesTransformer;
import net.mickilous.foobarqix.transformers.Transformer;

public class Application {

	public static void main(String[] args) {
		new Application().linesProcessor().printLines();
	}

	public LinesProcessor linesProcessor() {
		LinesProcessor lp = new LinesProcessor();
		lp.setOutputStream(System.out);
		lp.setTransformers(divisionTransformer(), occurencesTransformer());
		return lp;
	}

	public Transformer divisionTransformer() {
		return new DivisionTransformer();
	}

	public Transformer occurencesTransformer() {
		return new OccurencesTransformer();
	}

}
