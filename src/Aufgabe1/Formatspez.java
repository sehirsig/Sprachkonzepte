package Aufgabe1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//    %[argument_index$][flags][width][.precision]conversion
//    https://developer.android.com/reference/java/util/Formatter

public class Formatspez {
    static String ARGUMENT_INDEX = ".*?";
    static String FLAGS = "[-#+ 0,(]*";
    static String WIDTH = "\\d*";
    static String PRECISION = "(\\.\\d++)*";
    static String CONVERSION = "[a-zA-Z%]";
    static String PATTERN = "(%" + ARGUMENT_INDEX + FLAGS + WIDTH + PRECISION + CONVERSION + ")";

    public static void main(String[] args) {
        if (args.length != 0) {
            System.err.println("java RegexTest <format-string>");
            System.exit(1);
        }

        String formatString = "%1$-02.3dyyy";//args[0];
        int subStringStart = 0;

        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(formatString);

        while (matcher.find()) {
            printText(formatString.substring(subStringStart, matcher.start()));
            printFormat(matcher.group());

            subStringStart = matcher.end();
        }
        printText(formatString.substring(subStringStart));

        System.out.println();
    }

    private static void printText(String text) {
        if (!text.isEmpty())
            System.out.printf("TEXT(\"%s\")", text);
    }

    private static void printFormat(String format) {
        System.out.printf("FORMAT(\"%s\")", format);
    }

}