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
        String splitter = "\n|,";
        String replaced = numbers.replaceAll(delimiter, ",");
        String current = replaced.substring(replaced.indexOf(",")+1, replaced.indexOf(",")+2);
        int count = 0;
        while (current.equals(",")) {
            count++;
            splitter += ",";
            current = replaced.substring(replaced.indexOf(",")+count+1,replaced.indexOf(",")+count+2);
        }
        replaced = replaced.replace(splitter, ",");
        return replaced.split(splitter);
	}

	public static int sum(String[] numbers) {
		int sum = 0;
		int current = 0;
		String negatives = "";
		for (String number : numbers) {
			current = toInt(number);
			if (current < 0) {
				if (notEmpty(negatives))  {
					negatives += ",";
				}
				negatives += number;
			} else if (current <= 1000) {
				sum += current;
			}
		}
		if (notEmpty(negatives)) {
			throw new RuntimeException("Negatives not allowed: " + negatives);
		}
		return sum;
	}

	public static String findDelimiter(String text) {
        return "([^\\d])";
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