package is.ru.stringCalculator;

public class Calculator {

	public static int add(String text) {
		String delimiter = ",|\n";
		String textNoDelimiter = text;
		if (text.startsWith("//")) {
			int index = text.indexOf("//") + 2;
			delimiter = text.substring(index,index+1);
			textNoDelimiter = text.substring(text.indexOf("\n")+1);
		}
		if (textNoDelimiter.equals("")) {
			return 0;
		} else {
			String[] numbers = splitNumbers(textNoDelimiter, delimiter);
			return sum(numbers);
		}
	}

	public static int toInt(String number) {
		return Integer.parseInt(number);
	}

	public static String[] splitNumbers(String numbers, String delimiter) {
		return numbers.split(delimiter);
	}

	public static int sum(String[] numbers) {
		int sum = 0;
		for (String number : numbers) {
			sum += toInt(number);
		}
		return sum;
	}
}