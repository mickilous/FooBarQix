package net.mickilous.foobarqix;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;

import net.mickilous.foobarqix.transformers.Transformer;

import org.junit.Test;

public class LinesProcessorTestCase {

	LinesProcessor	lp	= new Application().linesProcessor();

	@Test
	public void testTransform_with_1() {
		assertThatNumber(1).isNotTransformed();
	}

	@Test
	public void testTransform_with_3() {
		assertThatNumber(3).isTransformedIn("FooFoo");
	}

	@Test
	public void testTransform_with_5() {
		assertThatNumber(5).isTransformedIn("BarBar");
	}

	@Test
	public void testTransform_with_7() {
		assertThatNumber(7).isTransformedIn("QixQix");
	}

	@Test
	public void testTransform_with_9() {
		assertThatNumber(9).isTransformedIn("Foo");
	}

	@Test
	public void testTransform_with_10() {
		assertThatNumber(10).isTransformedIn("Bar");
	}

	@Test
	public void testTransform_with_51() {
		assertThatNumber(51).isTransformedIn("FooBar");
	}

	@Test
	public void testTransform_with_53() {
		assertThatNumber(53).isTransformedIn("BarFoo");
	}

	@Test
	public void testTransform_with_21() {
		assertThatNumber(21).isTransformedIn("FooQix");
	}

	@Test
	public void testTransform_with_13() {
		assertThatNumber(13).isTransformedIn("Foo");
	}

	@Test
	public void testTransform_with_15() {
		assertThatNumber(15).isTransformedIn("FooBarBar");
	}

	@Test
	public void testTransform_with_33() {
		assertThatNumber(33).isTransformedIn("FooFooFoo");
	}

	@Test
	public void testTransform_with_35() {
		assertThatNumber(35).isTransformedIn("BarQixFooBar");
	}

	@Test
	public void testPrintLines() {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Transformer noTransfo = new Transformer() {
			@Override
			public String transform(int number) {
				return String.valueOf(number);
			}
		};
		lp.setOut(out);
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
			String actual = lp.transform(number);
			assertEquals(expected, actual);
		}

		void isNotTransformed() {
			String actual = lp.transform(number);
			assertEquals(String.valueOf(actual), actual);
		}

	}

}
