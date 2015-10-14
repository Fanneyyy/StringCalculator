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
}