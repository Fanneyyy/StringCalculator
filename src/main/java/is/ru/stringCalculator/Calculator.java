package is.ru.stringCalculator;

public class Calculator {

	public static int add(String text) {
		String delimiter = ",|\n";
		String textNoDelimiter = text;
		if (text.startsWith("//")) {
			delimiter = findDelimiter(text);
			textNoDelimiter = trimDelimiter(text);
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
		String negatives = "";
		for (String number : numbers) {
			if (toInt(number) < 0) {
				if (notEmpty(negatives))  {
					negatives += ",";
				}
				negatives += number;
			} else {
				sum += toInt(number);
			}
		}
		if (notEmpty(negatives)) {
			throw new RuntimeException("Negatives not allowed: " + negatives);
		}
		return sum;
	}

	public static String findDelimiter(String text) {
		int index = text.indexOf("//") + 2;
		return text.substring(index,index+1);
	}

	public static String trimDelimiter(String text) {
		return text.substring(text.indexOf("\n")+1);
	}

	public static boolean notEmpty(String s) {
		if (s.length() > 0) {
			return true;
		}
		return false;
	}
}