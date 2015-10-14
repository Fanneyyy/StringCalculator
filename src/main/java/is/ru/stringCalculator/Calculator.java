package is.ru.stringCalculator;

public class Calculator {

	public static int add(String text) {
		if (text.equals("")) {
			return 0;
		} else if (text.contains(",")) {
			String[] numbers = splitNumbers(text);
			return sum(numbers);
		} else {
			return toInt(text);
		}
	}

	public static int toInt(String number) {
		return Integer.parseInt(number);
	}

	public static String[] splitNumbers(String numbers) {
		return numbers.split(",|\n");
	}

	public static int sum(String[] numbers) {
		int sum = 0;
		for (String number : numbers) {
			sum += toInt(number);
		}
		return sum;
	}
}