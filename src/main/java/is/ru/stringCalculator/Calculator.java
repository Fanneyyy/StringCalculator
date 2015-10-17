package is.ru.stringCalculator;

import  java.util.regex.Pattern;

public class Calculator {

    public static int add(String text) {
        if (text.equals("")) {
            return 0;
        }
        String delimiter = ",|\n";
        if (text.startsWith("//[")) {
            delimiter = findDelimiter(text);
        } else if (text.startsWith("//")) {
            delimiter = text.substring(text.indexOf("/")+2,text.indexOf("\n"));
            delimiter = Pattern.quote(delimiter);
        }
        String textNoDelimiter = trimDelimiter(text);
        String[] numbers = splitNumbers(textNoDelimiter, delimiter);
        return sum(numbers);
    }

    public static int toInt(String number) {
        return Integer.parseInt(number);
    }

    public static String[] splitNumbers(String numbers, String delimiter) {
        return numbers.split(delimiter);
    }

    public static int sum(String[] numbers) {
        int current, sum = 0;
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
        String delimiter = text.substring(text.indexOf("[")+1,text.lastIndexOf("]"));
        delimiter = delimiter.replace("[", "");
        String[] delimiters = delimiter.split("]");
        String regexDelimiters = "";
        for (String del : delimiters) {
            regexDelimiters += Pattern.quote(del) + "|";
        }
        return regexDelimiters.substring(0,regexDelimiters.length()-1);
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