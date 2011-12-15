package net.mickilous.foobarqix;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import net.mickilous.foobarqix.transformers.Transformer;

import org.junit.Test;

public class LinesProcessorTestCase {

	LinesProcessor	lp	= new LinesProcessor();

	@Test
	public void testTransform_with_1() {
		assertTransform(1, "1");
	}

	@Test
	public void testTransform_with_3() {
		assertTransform(3, "FooFoo");
	}

	@Test
	public void testTransform_with_5() {
		assertTransform(5, "BarBar");
	}

	@Test
	public void testTransform_with_7() {
		assertTransform(7, "QixQix");
	}

	@Test
	public void testTransform_with_9() {
		assertTransform(9, "Foo");
	}

	@Test
	public void testTransform_with_10() {
		assertTransform(10, "Bar");
	}

	@Test
	public void testTransform_with_51() {
		assertTransform(51, "FooBar");
	}

	@Test
	public void testTransform_with_53() {
		assertTransform(53, "BarFoo");
	}

	@Test
	public void testTransform_with_21() {
		assertTransform(21, "FooQix");
	}

	@Test
	public void testTransform_with_13() {
		assertTransform(13, "Foo");
	}

	@Test
	public void testTransform_with_15() {
		assertTransform(15, "FooBarBar");
	}

	@Test
	public void testTransform_with_33() {
		assertTransform(33, "FooFooFoo");
	}

	@Test
	public void testTransform_with_35() {
		assertTransform(35, "BarQixFooBar");
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
		lp.setTransformers(Arrays.asList(noTransfo));

		lp.printLines();

		String[] lines = new String(out.toByteArray()).split(System.getProperty("line.separator"));
		assertEquals(LinesProcessor.MAX_NUMBER, lines.length);
		int i = 0;
		for (String line : lines) {
			assertEquals(String.valueOf(++i), line);
		}

	}

	private void assertTransform(int number, String expected) {

		String actual = lp.transform(number);
		assertEquals(expected, actual);

	}

}
