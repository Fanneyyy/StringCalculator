package is.ru.stringCalculator;

public class Calculator {

	public static int add(String text) {
		if (text.equals("")) {
			return 0;
		} else if (text.contains(",")) {
			String[] numbers = splitNumbers(text);
			int sum = 0;
			for (int i = 0; i < numbers.length; i++) {
				sum += toInt(numbers[i]);
			}
			return sum;
		} else {
			return toInt(text);
		}
	}

	public static int toInt(String number) {
		return Integer.parseInt(number);
	}

	public static String[] splitNumbers(String numbers) {
		return numbers.split(",");
	}
}