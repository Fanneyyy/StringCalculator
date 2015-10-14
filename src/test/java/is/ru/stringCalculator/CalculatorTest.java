package is.ru.stringCalculator;

import static org.junit.Assert.assertEquals;
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
	}
}