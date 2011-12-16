package net.mickilous.foobarqix;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;

import net.mickilous.foobarqix.transformers.Transformer;

import org.junit.Before;
import org.junit.Test;

public class LinesProcessorTestCase {

	private LinesProcessor	lp;

	@Before
	public void before() {
		lp = new Application().linesProcessor();
	}

	@Test
	public void testTransform_with_regular_numbers() {
		assertThatNumber(1).isNotTransformed();
		assertThatNumber(2).isNotTransformed();
		assertThatNumber(4).isNotTransformed();
		assertThatNumber(11).isNotTransformed();
	}

	@Test
	public void testTransform_with_3() {
		assertThatNumber(3).isTransformedIn("FooFoo");
		assertThatNumber(9).isTransformedIn("Foo");
		assertThatNumber(13).isTransformedIn("Foo");
		assertThatNumber(33).isTransformedIn("FooFooFoo");
	}

	@Test
	public void testTransform_with_5() {
		assertThatNumber(5).isTransformedIn("BarBar");
		assertThatNumber(10).isTransformedIn("Bar");
	}

	@Test
	public void testTransform_with_7() {
		assertThatNumber(7).isTransformedIn("QixQix");
	}

	@Test
	public void testTransform_with_combined_3_5_7() {
		assertThatNumber(51).isTransformedIn("FooBar");
		assertThatNumber(53).isTransformedIn("BarFoo");
		assertThatNumber(21).isTransformedIn("FooQix");
		assertThatNumber(15).isTransformedIn("FooBarBar");
		assertThatNumber(35).isTransformedIn("BarQixFooBar");
	}

	@Test
	public void testPrintLines_with_stubed_transformer() {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Transformer noTransfo = new Transformer() {
			@Override
			public String transform(int number) {
				return String.valueOf(number);
			}
		};
		lp.setOutputStream(out);
		lp.setTransformers(noTransfo);

		lp.printLines();

		String[] lines = new String(out.toByteArray()).split(System.getProperty("line.separator"));
		assertEquals(LinesProcessor.MAX_NUMBER, lines.length);
		int i = 0;
		for (String line : lines) {
			assertEquals(String.valueOf(++i), line);
		}

	}

	private AssertBuilder assertThatNumber(int number) {
		return new AssertBuilder(number);
	}

	private class AssertBuilder {
		int	number;

		private AssertBuilder(int number) {
			this.number = number;
		}

		void isTransformedIn(String expected) {
			String actual = lp.transformLine(number);
			assertEquals(expected, actual);
		}

		void isNotTransformed() {
			String actual = lp.transformLine(number);
			assertEquals(String.valueOf(actual), actual);
		}

	}

}
