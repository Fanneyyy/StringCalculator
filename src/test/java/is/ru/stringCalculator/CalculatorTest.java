package is.ru.stringCalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.stringCalculator.CalculatorTest");
	}

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(0, Calculator.add("0"));
		assertEquals(3, Calculator.add("3"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(2, Calculator.add("0,2"));
		assertEquals(5, Calculator.add("3,2"));
	}

	@Test
	public void testThreeNumbers() {
		assertEquals(7, Calculator.add("0,2,5"));
		assertEquals(13, Calculator.add("3,2,8"));
	}

	@Test
	public void testMoreThanThreeNumbers() {
		assertEquals(15, Calculator.add("1,2,3,4,5"));
		assertEquals(6, Calculator.add("0,1,1,1,1,1,1"));
	}

	@Test
	public void testInputWithEmbededNewlineChar() {
		assertEquals(7, Calculator.add("0\n2,5"));
	}

	@Test
	public void testDifferentDelimiters() {
		assertEquals(1+2+6, Calculator.add("//;\n1;2;6"));
		assertEquals(12+6+9, Calculator.add("//%\n12%6%9"));
	}

	@Test(expected = RuntimeException.class)
	public void testRuntimeExceptionWhenNegative() {
		Calculator.add("-1,-4");
	}

	@Test
	public void testRuntimeExceptionMessageWhenNegative() {
		RuntimeException exception = null;
		try {
			Calculator.add("-1,-4,4");
		} catch (RuntimeException e) {
			exception = e;
		}
		assertNotNull(null, exception);
		assertEquals("Negatives not allowed: -1,-4", exception.getMessage());
	}

	@Test
	public void testWhetherNumbersBiggerThenOneThousandAreIgnored() {
		assertEquals(3+6, Calculator.add("//;\n3;2000;6"));
		assertEquals(908, Calculator.add("//%\n1200%8%900"));
		assertEquals(1+2+4, Calculator.add("1,2,3300,4,50000"));
	}

	@Test
	public void testDelimitersOfAnyLength() {
		assertEquals(1+2+3, Calculator.add("//***\n1***2***3"));
		assertEquals(12+6+9, Calculator.add("//%%%%\n12%%%%6%%%%9"));
	}

	@Test
	public void testMultipleDelimiters() {
		assertEquals(1+2+3, Calculator.add("//[*][%]\n2*1%3"));
		assertEquals(6+6+6+9, Calculator.add("//[%][,][&][%]\n6&6,6%9"));
	}

	@Test
    public void testMultipleDelimitersOfAnyLength() {
        assertEquals(45+2+12, Calculator.add("//[**][%%%]\n45%%%2**12"));
        assertEquals(0+1+2+3+4, Calculator.add("//[##][$][%][,,,]\n0$1,,,2##3%4"));
    }

    @Test(expected = RuntimeException.class)
	public void testRuntimeExceptionWhenDelimitersAreIncorrect() {
		Calculator.add("//[**][%%]\n45%%%2**12");
	}
}